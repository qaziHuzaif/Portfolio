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
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import musaib.components.styles.SocialLinkStyle
import musaib.components.utils.Res
import musaib.components.widgets.LinkButton
import org.jetbrains.compose.web.css.cssRem

@Composable
fun SocialLinksRow(
    breakpoint: Breakpoint
) {

    // In Case we Dynamic Padding
    val bottomPadding = when (breakpoint) {
        Breakpoint.ZERO, Breakpoint.SM, Breakpoint.MD -> 3.cssRem
        else -> 3.cssRem
    }

    val spaceBetweenIcons = when (breakpoint) {
        Breakpoint.ZERO, Breakpoint.SM, Breakpoint.MD -> 1.5.cssRem
        else -> 2.5.cssRem
    }
    Row(
        modifier = Modifier
            .padding {
                top(1.cssRem)
                bottom(bottomPadding)
                     },
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenIcons),
        verticalAlignment = Alignment.CenterVertically
    ){

        // In Case Need Dynamic Sizes for Icons
        val iconSize = when (breakpoint) {
            Breakpoint.ZERO, Breakpoint.SM, Breakpoint.MD ->IconSize.X3
            else -> IconSize.X3
        }
        SocialLinkButton(
            Res.Constants.LINKEDIN_URL
        ) { FaLinkedin(size = iconSize) }

        SocialLinkButton(
            Res.Constants.GITHUB_URL
        ) { FaGithub(size = iconSize) }

        SocialLinkButton(
            Res.Constants.TWITTER_URL

        ) { FaXTwitter(size = iconSize) }

        SocialLinkButton(
            Res.Constants.HACKER_RANK_URL

        ) { FaHackerrank(size = iconSize) }

        SocialLinkButton(
            Res.Constants.MEDIUM_URL

        ) { FaMedium(size = iconSize) }

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


