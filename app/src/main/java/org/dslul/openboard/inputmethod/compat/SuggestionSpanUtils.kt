package org.dslul.openboard.inputmethod.compat

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.SuggestionSpan
import org.dslul.openboard.inputmethod.annotations.UsedForTesting
import java.util.*

object SuggestionSpanUtils {
    @JvmStatic
    @UsedForTesting
    fun getTextWithAutoCorrectionIndicatorUnderline(context: Context?, text: String, locale: Locale?): CharSequence {
        if (text.isEmpty())
            return text
        val spannable: Spannable = SpannableString(text)
        val suggestionSpan = SuggestionSpan(context, locale, arrayOf(), SuggestionSpan.FLAG_AUTO_CORRECTION, null)
        spannable.setSpan(suggestionSpan, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE or Spanned.SPAN_COMPOSING)
        return spannable
    }
}