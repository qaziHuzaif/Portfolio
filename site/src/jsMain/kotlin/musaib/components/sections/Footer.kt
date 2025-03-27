package musaib.components.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import musaib.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import musaib.components.sections.home.components.SocialLinkButton
import musaib.components.styles.MainButtonStyle
import musaib.components.utils.Res
import kotlin.js.Date
import kotlin.time.Duration.Companion.seconds


val FooterStyle = CssStyle {
    base {
        Modifier
            //.backgroundColor(colorMode.toSitePalette().nearBackground)
            .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)

    }

}

val FooterTextStyle = CssStyle {

    Breakpoint.ZERO {

        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.SM {

        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.MD {

        Modifier
            .fontSize(FontSize.Large)
    }

    Breakpoint.XL {

        Modifier
            .fontSize(FontSize.Medium)
    }

    Breakpoint.LG {

        Modifier
            .fontSize(FontSize.Medium)
    }


}

val TimeDisplayStyle = CssStyle {

    Breakpoint.SM {

        Modifier
            .width(10.cssRem)
    }
}



@Composable
fun FooterContactRow(modifier: Modifier) {

    // Contact Row If At Least SM Size
    Row (
        modifier = modifier
            .displayUntil(Breakpoint.SM)
            .fillMaxWidth()
            .padding { bottom(2.cssRem) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){

        ContactLinksRow(displayEmail = true)
    }



    // Contact Row If At Least MD Size
    Row (
        modifier = modifier
            .displayIfAtLeast(Breakpoint.MD)
            .fillMaxWidth()
            .padding { bottom(2.cssRem) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        val ctx = rememberPageContext()
        val currentPalette = ColorMode.current.toSitePalette()
        Button(
            onClick = {
                ctx.router.navigateTo(Res.Constants.MAIL_TO)
            },
            size = ButtonSize.MD,
            modifier = MainButtonStyle.toModifier()
                .background(currentPalette.buttonBackground)

        ) {
            SpanText(
                text = Res.Constants.EMAIL,
                modifier = Modifier
                    .color(currentPalette.buttonText)
                    .fontFamily("Lexend")
            )


        }

        ContactLinksRow()
    }
}

@Composable
fun DeveloperLocationInfoRow(modifier: Modifier) {

    // For Size SM

    Column(
        modifier = modifier.displayUntil(Breakpoint.SM),
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
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){

                FaLocationDot(
                    modifier = modifier
                        .padding(right = .5.cssRem)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.DimGray
                            }
                        )
                    ,
                    size = IconSize.XXS
                )

                SpanText(
                    text = "Srinagar J&K",
                    modifier = FooterTextStyle.toModifier()
                        .width(auto)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.DimGray
                            }
                        )
                )


            }

            TimeDisplay(
                modifier = TimeDisplayStyle.toModifier().width(10.cssRem),
                timeZone = "Asia/Kolkata"
            )
        }

        CopyrightInfo()
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

        CopyrightInfo()


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
                                ColorMode.DARK -> Colors.DimGray
                            }
                        )
                    ,
                    size = IconSize.XXS
                )
                SpanText(
                    text = "Srinagar J&K",
                    modifier = FooterTextStyle.toModifier()
                        .width(auto)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.DimGray
                            }
                        )
                )

                SpanText(
                    text = "|",
                    modifier = FooterTextStyle.toModifier()
                        .padding { leftRight(.5.cssRem) }
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.DimGray
                            }
                        )
                )

                TimeDisplay(
                    modifier = FooterTextStyle.toModifier().width(10.cssRem),
                    timeZone = "Asia/Kolkata"
                )
            }

        }
    }
}


@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column (
        modifier = FooterStyle.toModifier()
            .fillMaxWidth().id("contact")
    ){

        FooterContactRow(modifier = modifier)

        DeveloperLocationInfoRow(modifier = modifier)


    }
}


@Composable
fun CopyrightInfo() {

    SpanText(
        text = getCopyrightText(),
        modifier = FooterTextStyle.toModifier()
            .fillMaxWidth()
            .color(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Gray
                    ColorMode.DARK -> Colors.DimGray
                }
            )
    )
}

fun getCopyrightText(): String {
    // Get the current year using kotlinx-datetime
    val currentYear = Date().getFullYear().toString()
    return "© $currentYear | Developed by Musaib Shabir"
}


@Composable
fun TimeDisplay(
    modifier: Modifier = Modifier,
    timeZone: String
) {

    var currentTime by remember { mutableStateOf(getFormattedTime(timeZone)) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = getFormattedTime(timeZone)
            delay(1.seconds)
        }
    }

    SpanText(
        text = currentTime,
        modifier = FooterTextStyle.toModifier()
            .color(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Gray
                    ColorMode.DARK -> Colors.DimGray
                }
            )
    )
}

// Function to get the formatted time for a specific time zone
fun getFormattedTime(timeZone: String): String {
    val options = js("{ timeZone: timeZone, hour: '2-digit', minute: '2-digit', hour12: true }")
    return Date().toLocaleTimeString("en-US", options)
}

@Composable
fun DeveloperLocation() {

    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){

        FaLocationArrow(
            modifier = Modifier
                .padding(right = .5.cssRem)
                .color(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.DimGray
                    }
                )
        )
        SpanText(
            text = "Srinagar J&K India 190010",
            modifier = TimeDisplayStyle.toModifier()
                .fillMaxWidth()
                .color(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.DimGray
                    }
                )
        )
    }

}

@Composable
fun ContactLinksRow(
    displayEmail: Boolean = false
) {
    Row(
        modifier = Modifier
            .borderRadius(1.cssRem),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        if (displayEmail) {
            SocialLinkButton(
                Res.Constants.MAIL_TO
            ) { FaEnvelope(size = IconSize.XL) }
        }

        SocialLinkButton(
            Res.Constants.LINKEDIN_URL
        ) { FaLinkedinIn(size = IconSize.XL) }

        SocialLinkButton(
            Res.Constants.DISCORD_URL
        ) { FaDiscord(size = IconSize.XL) }

        SocialLinkButton(
            Res.Constants.WHATSAPP_URL
        ) { FaWhatsapp(size = IconSize.XL) }

        SocialLinkButton(
            Res.Constants.TELEGRAM_URL
        ) { FaTelegram(size = IconSize.XL) }

        SocialLinkButton(
            Res.Constants.INSTAGRAM_URL
        ) { FaInstagram(size = IconSize.XL) }
    }
}
