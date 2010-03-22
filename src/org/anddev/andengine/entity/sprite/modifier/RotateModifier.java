package org.anddev.andengine.entity.sprite.modifier;

import org.anddev.andengine.entity.sprite.BaseSprite;
import org.anddev.andengine.entity.sprite.IModifierListener;

/**
 * @author Nicolas Gramlich
 * @since 16:12:52 - 19.03.2010
 */
public class RotateModifier extends BaseFromToModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public RotateModifier(final float pDuration, final float pFromAngle, final float pToAngle) {
		this(pDuration, pFromAngle, pToAngle, null);
	}

	public RotateModifier(final float pDuration, final float pFromAngle, final float pToAngle, final IModifierListener pModiferListener) {
		super(pDuration, pFromAngle, pToAngle, pModiferListener);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected void onSetInitialValue(final float pValue, final BaseSprite pBaseSprite) {
		pBaseSprite.setAngle(pValue);
	}

	@Override
	protected void onSetValue(final float pValue, final BaseSprite pBaseSprite) {
		pBaseSprite.setAngle(pValue);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}