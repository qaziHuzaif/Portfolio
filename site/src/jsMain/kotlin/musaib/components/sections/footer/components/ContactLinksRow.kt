package musaib.components.sections.footer.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.silk.components.icons.fa.FaDiscord
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaInstagram
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedinIn
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.icons.fa.FaWhatsapp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import musaib.components.sections.home.components.SocialLinkButton
import musaib.components.utils.Res
import org.jetbrains.compose.web.css.cssRem

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