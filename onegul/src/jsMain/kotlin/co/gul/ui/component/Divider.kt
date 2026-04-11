package co.gul.ui.component

import androidx.compose.runtime.Composable
import co.gul.ui.theme.AppStyle
import org.jetbrains.compose.web.dom.Hr

@Composable
fun Divider() {
    Hr(attrs = { classes(AppStyle.divider) })
}