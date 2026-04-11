package co.gul.ui.component

import androidx.compose.runtime.Composable
import co.gul.ui.theme.AppStyle
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionHeader(heading: String, subheading: String) {
    H1(attrs = { classes(AppStyle.sectionHeading) }) { Text(heading) }
    P(attrs = { classes(AppStyle.sectionSubheading) }) { Text(subheading) }
}