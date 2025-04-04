package musaib.components.sections.home.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import musaib.components.styles.SocialLinkStyle
import musaib.components.utils.Res
import musaib.components.widgets.LinkButton
import org.jetbrains.compose.web.css.cssRem

@Composable
fun SocialLinksRow() {
    Row(
        modifier = Modifier.padding { top(1.cssRem) },
        horizontalArrangement = Arrangement.spacedBy(2.cssRem),
        verticalAlignment = Alignment.CenterVertically
    ){


        SocialLinkButton(
            Res.Constants.LINKEDIN_URL
        ) { FaLinkedin(size = IconSize.X3) }

        SocialLinkButton(
            Res.Constants.GITHUB_URL
        ) { FaGithub(size = IconSize.X3) }

        SocialLinkButton(
            Res.Constants.TWITTER_URL

        ) { FaXTwitter(size = IconSize.X3) }

        SocialLinkButton(
            Res.Constants.HACKER_RANK_URL

        ) { FaHackerrank(size = IconSize.X3) }

        SocialLinkButton(
            Res.Constants.MEDIUM_URL

        ) { FaMedium(size = IconSize.X3) }

    }
}

@Composable
internal fun SocialLinkButton(
    url: String,
    icon: @Composable () -> Unit
) {
    LinkButton(
        url,
        modifier =  SocialLinkStyle.toModifier()
            .color(
            when (ColorMode.current) {
                ColorMode.LIGHT -> Colors.Black
                ColorMode.DARK -> Colors.White
            }
        )
            .backgroundColor(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Transparent
                    ColorMode.DARK -> Colors.Transparent
                }
            )
    ) {
        icon()
    }
}


