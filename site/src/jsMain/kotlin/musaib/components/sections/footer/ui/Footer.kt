package musaib.components.sections.footer.ui

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.BackgroundBlendMode
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import musaib.components.sections.footer.components.DeveloperLocationInfoRow
import musaib.components.sections.footer.components.FooterContactRow
import musaib.components.sections.footer.components.GetInTouchColumn
import musaib.components.sections.footer.style.FooterStyle
import musaib.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px


@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column (
        modifier = FooterStyle.toModifier()
            .fillMaxWidth()
            .id("contact")
            .backgroundBlendMode(BackgroundBlendMode.ColorBurn)
    ){
        val colorPalette = ColorMode.current.toSitePalette()

        Column(
            modifier = modifier
                .fillMaxWidth()

        ) {

            GetInTouchColumn()

            FooterContactRow()

            DeveloperLocationInfoRow(modifier = modifier.padding { topBottom(0.5.cssRem) })
        }




    }
}


val footerBackStyle = CssStyle.base {

    val colorPalette = colorMode.toPalette()
    Modifier
        .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
        .backdropFilter(saturate(180.percent), blur(8.px))
}












