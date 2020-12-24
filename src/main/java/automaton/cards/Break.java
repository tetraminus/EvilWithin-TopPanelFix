package automaton.cards;

import automaton.AutomatonMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static sneckomod.SneckoMod.getRandomStatus;

public class Break extends AbstractBronzeCard {

    public final static String ID = makeID("Break");

    //stupid intellij stuff attack, enemy, rare

    private static final int DAMAGE = 36;
    private static final int UPG_DAMAGE = 8;

    public Break() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = 3;
        thisEncodes();
        tags.add(AutomatonMod.BAD_COMPILE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
    }

    @Override
    public void onCompile(AbstractCard function, boolean forGameplay) {
        super.onCompile(function, forGameplay);
        if (forGameplay) {
            for (int i = 0; i < magicNumber; i++) {
                AbstractCard q = getRandomStatus().makeStatEquivalentCopy();
                if (upgraded) {
                    atb(new MakeTempCardInDiscardAction(q, 1));
                } else {
                    shuffleIn(q, 1);
                }
            }
        }
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}