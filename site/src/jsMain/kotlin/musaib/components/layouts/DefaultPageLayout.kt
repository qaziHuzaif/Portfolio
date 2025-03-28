package musaib.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import kotlinx.browser.document
import musaib.components.sections.Footer
import musaib.components.sections.NavHeader
import musaib.components.sections.projects.components.AppearanceAwareImage
import musaib.components.utils.Res
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh


@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun SVGBackroundCircle(modifier: Modifier = Modifier) {
    AppearanceAwareImage(
        src = Res.Images.HOME_BACKGROUND_TOP_RIGHT_SHAPE,
        dyanmicColor = false,
        modifier = modifier
            .position(Position.Absolute)
            .top(0.px)
            .right(0.px)
            .height(100.vh)
            .pointerEvents(PointerEvents.None)
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
            .fillMaxSize()
            .position(Position.Relative)
    ) {
        SVGBackroundCircle(modifier = Modifier.displayIfAtLeast(Breakpoint.XL))
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHeader()
            content()
            Footer()
        }
    }
}