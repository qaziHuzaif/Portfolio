package musaib.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import kotlinx.browser.document
import musaib.components.sections.footer.ui.Footer
import musaib.components.sections.navHeader.ui.NavHeader
import musaib.components.utils.Res
import musaib.components.widgets.SVGHeroBackround
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh


@Composable
fun DefaultPageLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    LaunchedEffect(title) {
        document.title = "Musaib Shabir"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Relative)
    ) {

        // For Display Size Until MD
        SVGHeroBackround(
            modifier = Modifier
                .displayUntil(Breakpoint.MD)
                .top((-50).px)
                .left((-50).px)
                .height(28.vh)

            ,
            src = Res.Images.GREEN_CIRCE
        )

        // For Display Size After  MD
        SVGHeroBackround(
            modifier = Modifier
                .displayIfAtLeast(Breakpoint.LG)
                .top(0.px)
                .right(0.px)
                .height(100.vh)
            ,
            src = Res.Images.WAVES
        )

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