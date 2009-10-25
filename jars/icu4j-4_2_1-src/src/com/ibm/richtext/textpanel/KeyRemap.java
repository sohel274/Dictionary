/*
 * (C) Copyright IBM Corp. 1998-2004.  All Rights Reserved.
 *
 * The program is provided "as is" without any warranty express or
 * implied, including the warranty of non-infringement and the implied
 * warranties of merchantibility and fitness for a particular purpose.
 * IBM will not be liable for any damages suffered by you as a result
 * of using the Program. In no event will IBM be liable for any
 * special, indirect or consequential damages or lost profits even if
 * IBM has been advised of the possibility of their occurrence. IBM
 * will not be liable for any third party claims against you.
 */
/*
 *
 * (C) Copyright IBM Corp. 1998, All Rights Reserved
 */

package com.ibm.richtext.textpanel;

import java.awt.event.KeyEvent;

/**
 * KeyRemap maps keys on a standard US keyboard to characters
 * in other alphabets.  Currently, mappings to Arabic, Hebrew
 * and Thai are supported.  In the future, clients may be
 * to define their own mappings by subclassing this class.
 * <P>
 * @see TextPanel#setKeyRemap
 */

public class KeyRemap {

    static final String COPYRIGHT =
                "(C) Copyright IBM Corp. 1998-1999 - All Rights Reserved";
    /**
     * Create a new KeyRemap.
     */
    protected KeyRemap() {
    }

    /**
     * This method returns the character on the simulated keyboard
     * which is (most likely) generated by typing the character c
     * on the actual keyboard.  For greater accuracy, use the remap
     * method which takes a KeyEvent, since it can take modifier
     * keys into account.
     * @arg c a character on the actual keyboard
     * @return the character on the simulated keyboard which would
     *         result from the key combination which produced the
     *         given character on the actual keyboard
     */
    /*public*/ char remap(char c) {

        return c;
    }

    /**
     * Return the character on the simulated keyboard
     * which keyEvent generates.
     * @arg keyEvent a key event from the actual keyboard
     * @return the character on the simulated keyboard generated by
     *         keyEvent
     */
    /*public*/ char remap(KeyEvent keyEvent) {

        return remap(keyEvent.getKeyChar());
    }

    private static final KeyRemap IDENTITY = new KeyRemap();
    private static final KeyRemap ARABIC_TRANSLITERATION = new ArabicTransliteration();
    private static final KeyRemap HEBREW_TRANSLITERATION = new HebrewTransliteration();
    private static final KeyRemap ISRAEL_NIKUD = new IsraelNikudKeyboard();
    private static final KeyRemap THAI = new ThaiKeyRemap();

    /**
     * Return a KeyRemap which maps every character to itself.
     */
    public static KeyRemap getIdentityRemap() {

        return IDENTITY;
    }

    /**
     * Return a KeyRemap which maps keys to
     * characters in the Arabic alphabet, using a simple transliteration.
     */
    public static KeyRemap getArabicTransliteration() {

        return ARABIC_TRANSLITERATION;
    }

    /**
     * Return a KeyRemap which maps keys to
     * characters in the Hebrew alphabet, using a simple transliteration.
     */
    public static KeyRemap getHebrewTransliteration() {

        return HEBREW_TRANSLITERATION;
    }

    /**
     * Return a KeyRemap which emulates a standard Hebrew keyboard.
     */
    public static KeyRemap getIsraelNikud() {

        return ISRAEL_NIKUD;
    }
    
    /**
     * Return a KeyRemap which emulates a Thai Ketmanee keyboard.
     */
    public static KeyRemap getThaiKetmanee() {
        
        return THAI;
    }
}
