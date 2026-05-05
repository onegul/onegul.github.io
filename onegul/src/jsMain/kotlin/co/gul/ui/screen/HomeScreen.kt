package co.gul.ui.screen

import androidx.compose.runtime.Composable
import co.gul.ui.component.SiteFooter
import co.gul.ui.theme.AppStyle
import org.jetbrains.compose.web.dom.*

@Composable
fun HomeScreen() {
    Main {
        Article(attrs = { classes(AppStyle.sectionContainer) }) {
            H1(attrs = { classes(AppStyle.heroHeading) }) {
                Text("Android Engineer")
                Br()
                Em(attrs = { classes(AppStyle.heroAccent) }) { Text("Reading") }
                Br()
                Text("slow walks.")
            }

            P(attrs = { classes(AppStyle.heroBody) }) {
                Text(
                    "I do Android development, having started with Java and then pivoted to Kotlin. " +
                            "Over the course of 6 years at multiple companies, I've built and managed apps that do " +
                            "live-streaming, classroom management, automated attendance, sports analytics " +
                            "and IMU-based use cases. I'm usually building apps implementing new ideas that I think " +
                            "are useful. I love going on long, slow walks and listening to Nusrat Fateh Ali Khan, " +
                            "Satinder Sartaaj, and Rachmaninoff. I read old books, literature, poetry, religious " +
                            "texts, mathematics, and computer science. When I'm not doing any of the above, I'm " +
                            "usually having a beer with friends."
                )
            }
        }

        SiteFooter()
    }
}