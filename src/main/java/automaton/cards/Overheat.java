package automaton.cards;

import automaton.AutomatonMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Overheat extends AbstractBronzeCard {

    public final static String ID = makeID("Overheat");

    //stupid intellij stuff attack, enemy, common

    private static final int DAMAGE = 14;
    private static final int UPG_DAMAGE = 4;

    public Overheat() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        thisEncodes();
        AbstractCard q = new Burn();
        q.upgrade();
        cardsToPreview = q;
        tags.add(AutomatonMod.BAD_COMPILE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        atb(new DamageAction(p, new DamageInfo(p, 4, damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
    }

    @Override
    public void onCompile(AbstractCard function, boolean forGameplay, int count) {
        super.onCompile(function, forGameplay, count);
        if (forGameplay) {
            AbstractCard c = new Burn();
            c.upgrade();
            shuffleIn(c);
        }
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}