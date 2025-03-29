package musaib.components.sections

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
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
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import musaib.components.sections.home.components.SocialLinkButton
import musaib.components.styles.FooterStyle
import musaib.components.styles.FooterTextStyle
import musaib.components.styles.MainButtonStyle
import musaib.components.utils.Res
import musaib.toSitePalette
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.cssRem
import kotlin.js.Date
import kotlin.time.Duration.Companion.seconds


@Composable
fun FooterContactRow(modifier: Modifier = Modifier) {

    // Contact Row If At Least SM Size
    Row (
        modifier = modifier
            .displayUntil(Breakpoint.SM)
            .fillMaxWidth()

                ,
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
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        val ctx = rememberPageContext()
        val currentPalette = ColorMode.current.toSitePalette()
        Button(
            onClick = {
                ctx.router.navigateTo(Res.Constants.MAIL_TO)
            },
            size = ButtonSize.LG,
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


@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column (
        modifier = FooterStyle.toModifier()
            .fillMaxWidth().id("contact")
    ){


        GetInTouchColumn()

        FooterContactRow()

       DeveloperLocationInfoRow(modifier = modifier.padding { topBottom(0.5.cssRem) })


    }
}

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


@Composable
fun FooterSpanText(text: String, modifier: Modifier = Modifier) {
    SpanText(
        text = text,
        modifier = FooterTextStyle.toModifier().then(modifier)

            .color(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Gray
                    ColorMode.DARK -> Colors.LightGray
                }
            )
    )
}




fun getCopyrightText(): String {
    // Get the current year using kotlinx-datetime
    val currentYear = Date().getFullYear().toString()
    return "© $currentYear | ${Res.Constants.COPYRIGHT}"
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
        modifier = FooterTextStyle.toModifier().then(modifier)
            .width(5.cssRem)
            .alignContent(AlignContent.End)
            .color(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Gray
                    ColorMode.DARK -> Colors.LightGray
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
            ) { FaEnvelope(size = IconSize.XXL) }
        }

        SocialLinkButton(
            Res.Constants.LINKEDIN_URL
        ) { FaLinkedinIn(size = IconSize.XXL) }

        SocialLinkButton(
            Res.Constants.DISCORD_URL
        ) { FaDiscord(size = IconSize.XXL) }

        SocialLinkButton(
            Res.Constants.WHATSAPP_URL
        ) { FaWhatsapp(size = IconSize.XXL) }

        SocialLinkButton(
            Res.Constants.TELEGRAM_URL
        ) { FaTelegram(size = IconSize.XXL) }

        SocialLinkButton(
            Res.Constants.INSTAGRAM_URL
        ) { FaInstagram(size = IconSize.XXL) }
    }
}
