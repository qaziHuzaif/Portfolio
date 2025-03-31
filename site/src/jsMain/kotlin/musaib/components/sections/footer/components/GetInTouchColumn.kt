package musaib.components.sections.footer.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import musaib.components.utils.Res
import musaib.toSitePalette
import org.jetbrains.compose.web.css.cssRem

@Composable
fun GetInTouchColumn(modifier: Modifier = Modifier) {

    Column (
        modifier = modifier
            .fillMaxWidth()
        ,
        horizontalAlignment = Alignment.Start
    ){

        // Get in Touch
        Row (
            modifier = modifier.fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){

            SpanText(
                text = Res.Constants.GET_IN_TOUCH,
                modifier = modifier
                    .fontSize(2.cssRem)
                    .fontWeight(FontWeight.Black)
                    .color(ColorMode.current.toSitePalette().subHeadLine)
            )
        }

        // Discription

        // For Size SM & Below
        Column (
            modifier = modifier
                .displayUntil(Breakpoint.MD)
                .fillMaxWidth()
                .padding(top = 1.cssRem, bottom = 3.cssRem)
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            SpanText(
                text = Res.Constants.GET_IN_TOUCH_DISCRIPTION,
                modifier = modifier
                    .fontSize(FontSize.Large)
                    .textAlign(TextAlign.Justify)
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.LightGray
                        }
                    )
            )
        }

        // For Size MD & Above
        Column (
            modifier = modifier
                .displayIfAtLeast(Breakpoint.MD)
                .width(52.cssRem)
                .padding(top = 1.cssRem, bottom = 3.cssRem)
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            SpanText(
                text = Res.Constants.GET_IN_TOUCH_DISCRIPTION,
                modifier = modifier
                    .fontSize(FontSize.Large)
                    .textAlign(TextAlign.Justify)
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.LightGray
                        }
                    )
            )
        }
    }
}