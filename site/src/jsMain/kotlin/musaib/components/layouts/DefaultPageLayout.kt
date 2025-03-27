package musaib.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import kotlinx.browser.document
import musaib.components.sections.Footer
import musaib.components.sections.NavHeader
import musaib.components.sections.projects.components.AppearanceAwareImage
import musaib.components.utils.Res
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun SVGBackroundCircle(modifier: Modifier = Modifier) {
    AppearanceAwareImage(
        src = Res.Images.BACKGROUND_COMPASS,
        modifier = modifier
            .position(Position.Absolute) // Position it absolutely
            .top(0.px) // Stick to the top
            .right(0.px) // Align to the right
            //.zIndex(1) // Push it to the background
            .pointerEvents(PointerEvents.None)
            .size(403.px)

    )
}




@Composable
fun DefaultPageLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    LaunchedEffect(title) {
        document.title = "Musaib Shabir - $title"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            //.position(Position.Relative) // Ensures absolute children stay within this
    ) {
        //SVGBackroundCircle() // Background SVG at the top-right

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHeader() // Navigation bar stays on top
            content() // Main content
            Footer() // Footer at the bottom
        }
    }
}
