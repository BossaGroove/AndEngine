package org.andengine.util.modifier.ease;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseBackOut implements IEaseFunction {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final float OVERSHOOT_CONSTANT = 1.70158f;

	// ===========================================================
	// Fields
	// ===========================================================

	private static EaseBackOut INSTANCE;

	private float mOvershootValue = OVERSHOOT_CONSTANT;

	// ===========================================================
	// Constructors
	// ===========================================================

	private EaseBackOut() {

	}

	public static EaseBackOut getInstance(float pOverShootValue) {
		if (INSTANCE == null) {
			INSTANCE = new EaseBackOut();
		}
		INSTANCE.mOvershootValue = pOverShootValue;
		return INSTANCE;
	}

	public static EaseBackOut getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EaseBackOut();
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
		return EaseBackOut.getValue(pSecondsElapsed / pDuration);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public static float getValue(final float pPercentage) {
		final float t = pPercentage - 1;
		return 1 + t * t * ((EaseBackOut.getInstance().getOverShootValue() + 1) * t + EaseBackOut.getInstance().getOverShootValue());
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
