package org.andengine.util.modifier.ease;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseBackIn implements IEaseFunction {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final float OVERSHOOT_CONSTANT = 1.70158f;

	// ===========================================================
	// Fields
	// ===========================================================

	private static EaseBackIn INSTANCE;

	private float mOvershootValue = OVERSHOOT_CONSTANT;

	// ===========================================================
	// Constructors
	// ===========================================================

	private EaseBackIn() {

	}

	public static EaseBackIn getInstance(float pOverShootValue) {
		if (INSTANCE == null) {
			INSTANCE = new EaseBackIn();
		}
		INSTANCE.mOvershootValue = pOverShootValue;
		return INSTANCE;
	}

	public static EaseBackIn getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EaseBackIn();
		}
		return INSTANCE;
	}

	public float getOverShootValue() {
		return this.mOvershootValue;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public float getPercentage(final float pSecondsElapsed, final float pDuration) {
		return EaseBackIn.getValue(pSecondsElapsed / pDuration);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public static float getValue(final float pPercentage) {
		return pPercentage * pPercentage * ((EaseBackIn.getInstance().getOverShootValue() + 1) * pPercentage - EaseBackIn.getInstance().getOverShootValue());
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
