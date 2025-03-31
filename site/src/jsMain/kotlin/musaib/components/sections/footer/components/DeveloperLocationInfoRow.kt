package musaib.components.sections.footer.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaLocationDot
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import musaib.components.styles.FooterTextStyle
import musaib.components.utils.Res
import org.jetbrains.compose.web.css.cssRem
import kotlin.js.Date

@Composable
fun DeveloperLocationInfoRow(modifier: Modifier) {

    // For Size SM
    Column(
        modifier = modifier
            .fillMaxWidth()
            .displayUntil(Breakpoint.MD),
        verticalArrangement = Arrangement.spacedBy(1.cssRem)
    ) {
        Row (
            modifier = modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            Row (
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){

                FaLocationDot(
                    modifier = modifier
                        .padding(right = .5.cssRem)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.LightGray
                            }
                        )
                    ,
                    size = IconSize.XXS
                )

                SpanText(
                    text = "Srinagar J&K",
                    modifier = FooterTextStyle.toModifier()
                        .width(6.cssRem)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.LightGray
                            }
                        )
                )


            }


            TimeDisplay(
                timeZone = "Asia/Kolkata"
            )

        }

        FooterSpanText(
            text = getCopyrightText(),
            modifier = modifier.fillMaxWidth()
        )
    }


    // For Size MD & Above
    Row (
        modifier = modifier
            .displayIfAtLeast(Breakpoint.MD)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        FooterSpanText(
            text = getCopyrightText(),
            modifier = modifier.fillMaxWidth()
        )


        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                FaLocationDot(
                    modifier = modifier
                        .padding(right = .5.cssRem)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.LightGray
                            }
                        )
                    ,
                    size = IconSize.XXS
                )
                FooterSpanText(text = Res.Constants.DEVELOPER_LOCATION)

                FooterSpanText(
                    text = "|",
                    modifier = modifier.padding {
                        leftRight(.5.cssRem)
                    }
                )

                TimeDisplay(timeZone = "Asia/Kolkata")
            }

        }
    }
}


fun getCopyrightText(): String {

    val currentYear = Date().getFullYear().toString()
    return "© $currentYear | ${Res.Constants.COPYRIGHT}"
}
