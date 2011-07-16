package org.anddev.andengine.entity.modifier;

import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Pawel Plewa
 * @author Nicolas Gramlich
 * @since 23:24:26 - 16.07.2011
 */
public class CubicBezierMoveModifier extends DurationEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final float mX1;
	private final float mY1;
	private final float mX2;
	private final float mY2;
	private final float mX3;
	private final float mY3;
	private final float mX4;
	private final float mY4;

	private final IEaseFunction mEaseFunction;

	// ===========================================================
	// Constructors
	// ===========================================================

	public CubicBezierMoveModifier(final float pDuration, final float pX1, final float pY1, final float pX2, final float pY2, final float pX3, final float pY3, final float pX4, final float pY4, final IEaseFunction pEaseFunction) {
		super(pDuration);

		this.mX1 = pX1;
		this.mY1 = pY1;
		this.mX2 = pX2;
		this.mY2 = pY2;
		this.mX3 = pX3;
		this.mY3 = pY3;
		this.mX4 = pX4;
		this.mY4 = pY4;

		this.mEaseFunction = pEaseFunction;
	}

	@Override
	public CubicBezierMoveModifier clone() {
		return new CubicBezierMoveModifier(this.mDuration, this.mX1, this.mY1, this.mX2, this.mY2, this.mX3, this.mY3, this.mX4, this.mY4, this.mEaseFunction);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onManagedUpdate(final float pSecondsElapsed, final IEntity pEntity) {
		final float percentageDone = this.mEaseFunction.getPercentageDone(this.getSecondsElapsed(), this.mDuration, 0, 1);

		final float u = 1 - percentageDone;
		final float tt = percentageDone * percentageDone;
		final float uu = u * u;
		final float uuu = uu * u;
		final float ttt = tt * percentageDone;
		
		final float ut3 = 3 * uu * percentageDone;
		final float utt3 = 3 * u * tt;
		
		/*
		 * Formula: ((1-t)^3 * p1) + (3*(t)*(1-t)^2 * p2) + (3*(t^2)*(1-t) * p3) + (t^3 * p4)
		 */
		final float x = (uuu * this.mX1) + (ut3 * this.mX2) + (utt3 * this.mX3) + (ttt * this.mX4);
		final float y = (uuu * this.mY1) + (ut3 * this.mY2) + (utt3 * this.mY3) + (ttt * this.mY4);
		
		pEntity.setPosition(x, y);
	}

	@Override
	protected void onManagedInitialize(final IEntity pEntity) {

	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

	public void updatePosition(final float pPercentageDone, final IEntity pEntity) {
		final float u = 1 - pPercentageDone;
		final float tt = pPercentageDone * pPercentageDone;
		final float uu = u * u;
		final float uuu = uu * u;
		final float ttt = tt * pPercentageDone;

		final float ut3 = 3 * uu * pPercentageDone;
		final float utt3 = 3 * u * tt;

		/*
		 * Formula: ((1-t)^3 * p1) + (3*(t)*(1-t)^2 * p2) + (3*(t^2)*(1-t) * p3)
		 * + (t^3 * p4)
		 */
		final float x = (uuu * this.mX1) + (ut3 * this.mX2) + (utt3 * this.mX3) + (ttt * this.mX4);
		final float y = (uuu * this.mY1) + (ut3 * this.mY2) + (utt3 * this.mY3) + (ttt * this.mY4);

		pEntity.setPosition(x, y);
	}
}