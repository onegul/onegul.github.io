package co.gul.ui.component

import androidx.compose.runtime.Composable
import co.gul.ui.theme.AppStyle
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun TagChip(text: String) {
    Span(attrs = { classes(AppStyle.tag) }) { Text(text) }
}