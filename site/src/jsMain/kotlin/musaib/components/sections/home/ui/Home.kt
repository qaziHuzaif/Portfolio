package musaib.components.sections.home.ui


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import musaib.SitePalette
import musaib.SubheadlineTextStyle
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.s
import org.jetbrains.compose.web.dom.Div
import musaib.components.HeroContainerKeyFrames
import musaib.components.UserNameStyle
import musaib.components.UsersMessageStyle
import org.musaibshabir.portfolio.components.sections.home.components.SocialLinksRow
import org.musaibshabir.portfolio.components.sections.home.style.HelloImStyle
import org.musaibshabir.portfolio.components.sections.home.style.HeroSectionStyle
import musaib.components.styles.MainButtonStyle
import musaib.components.utils.Res

@Composable
fun Home(
    currentPalette: SitePalette
) {

    Row(
        modifier = Modifier
            .fillMaxWidth().id("home"),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = HeroSectionStyle.toModifier().animation(HeroContainerKeyFrames.toAnimation(
                duration = 2.s,
                timingFunction = AnimationTimingFunction.EaseInOut
            )),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            SpanText(
                text = Res.Constants.GREETING,
                modifier = HelloImStyle.toModifier()
                    .fontWeight(FontWeight.Lighter)
            )
            SpanText(
                text = Res.Constants.NAME,
                modifier = UserNameStyle.toModifier()

                    .fontWeight(FontWeight.Bold)
            )

            Div(
                SubheadlineTextStyle.toModifier()
                    .color(currentPalette.subHeadLine)
                    .margin(top = 5.px)
                    .toAttrs()
            ) {
                SpanText(
                    text = Res.Constants.SUB_HEADLINE,
                    modifier = UsersMessageStyle.toModifier()
                        .color(currentPalette.subHeadLine)

                )
            }

            val ctx = rememberPageContext()


            SocialLinksRow()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.cssRem)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.cssRem)
            ) {

                Button(
                    onClick = {
                        ctx.router.navigateTo(Res.Constants.RESUME_URL)
                    },
                    size = ButtonSize.MD,
                    modifier = MainButtonStyle.toModifier()
                        .background(currentPalette.buttonBackground)
                        //.width(120.px)
                ) {
                    SpanText(
                        text = Res.Constants.RESUME,
                        modifier = Modifier
                            .color(currentPalette.buttonText)
                            .fontFamily("Lexend")
                    )
                }

            }

        }


    }

}
