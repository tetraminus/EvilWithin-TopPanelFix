package evilWithin.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;
import evilWithin.EvilWithinMod;

public class RedIOU extends CustomRelic {

    public static String ID = EvilWithinMod.makeID("RedIOU");
    private static Texture IMG = new Texture(EvilWithinMod.assetPath("images/relics/BanditContract.png"));
    private static Texture OUTLINE = new Texture(EvilWithinMod.assetPath("images/relics/BanditContract.png"));

    public RedIOU() {
        super(ID, IMG, OUTLINE, RelicTier.SPECIAL, LandingSound.FLAT);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void atBattleStart() {
        if (AbstractDungeon.getCurrRoom() instanceof MonsterRoomBoss && AbstractDungeon.actNum == 3) {
            flash();
        }
    }

}
