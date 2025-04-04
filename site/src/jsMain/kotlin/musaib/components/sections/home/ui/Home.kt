package musaib.components.sections.home.ui


import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.toModifier
import musaib.SitePalette
import musaib.components.sections.home.components.SocialLinksRow
import musaib.components.sections.home.style.*
import musaib.components.styles.MainButtonStyle
import musaib.components.utils.Res
import org.jetbrains.compose.web.css.AnimationTimingFunction
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.s

@Composable
fun Home(
    currentPalette: SitePalette
) {

    Row(
        modifier = HeroSectionStyle.toModifier()
            .fillMaxWidth().id("home"),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .animation(HeroContainerKeyFrames.toAnimation(
                    duration = 1.5.s,
                    timingFunction = AnimationTimingFunction.cubicBezier(
                        0.03, 0.96, 0.19, 0.97
                    ),

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

            SpanText(
                text = Res.Constants.SUB_HEADLINE,
                modifier = UsersMessageStyle.toModifier()
                    .color(currentPalette.subHeadLine)

            )

            val ctx = rememberPageContext()


            SocialLinksRow()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.cssRem)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.cssRem)
            ) {

                Button(
                    onClick = {
                        ctx.router.navigateTo(Res.Constants.RESUME_URL)
                    },
                    size = ButtonSize.LG,
                    modifier = MainButtonStyle.toModifier()
                        .background(currentPalette.buttonBackground)

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
