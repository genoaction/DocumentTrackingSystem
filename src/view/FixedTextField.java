package view;

import javax.swing.text.*;

public class FixedTextField extends PlainDocument {
    private final int max = 7;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (getLength() + str.length() <= max) {
            super.insertString(offs, str, a);
        }
    }
}
