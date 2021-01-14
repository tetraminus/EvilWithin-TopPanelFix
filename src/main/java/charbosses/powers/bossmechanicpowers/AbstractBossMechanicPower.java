//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package charbosses.powers.bossmechanicpowers;

import basemod.ReflectionHacks;
import charbosses.bosses.AbstractCharBoss;
import charbosses.vfx.QuietGainPowerEffect;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.GainPowerEffect;

import java.util.ArrayList;

public abstract class AbstractBossMechanicPower extends AbstractPower {

    private float timer;
    private boolean firstTurn = true;

    @Override
    public void update(int slot) {
        super.update(slot);
        if (firstTurn){
            if (this.timer <= 0F){
                ArrayList<AbstractGameEffect> effect2 = (ArrayList<AbstractGameEffect>) ReflectionHacks.getPrivate(this, AbstractPower.class, "effect");
                effect2.add(new QuietGainPowerEffect(this));
                this.timer = 1F;
                if (AbstractCharBoss.boss != null) {
                    if (AbstractCharBoss.boss.hb.hovered) {
                        firstTurn = false;
                    }
                }
            } else {
                this.timer -= Gdx.graphics.getDeltaTime();
            }
        }
    }

    @Override
    public void atStartOfTurn() {
        super.atStartOfTurn();
        firstTurn = false;
    }

    @Override
    public void playApplyPowerSfx() {
        //to prevent the 'last turn' warning from pinging audio all the time
    }

}
