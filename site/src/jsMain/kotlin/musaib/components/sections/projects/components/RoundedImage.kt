package org.musaibshabir.portfolio.components.sections.projects.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px
import musaib.components.utils.Res

@Composable
fun RoundedImage(
    modifier: Modifier = Modifier,
    src: String,
    navigateTo: String? = null
) {
    val ctx = rememberPageContext()

    Box(
        modifier = Modifier.fillMaxSize().padding(5.px).borderRadius(10.px).then(modifier).cursor(Cursor.Pointer)
            .onClick {
                navigateTo?.let {
                    ctx.router.navigateTo(it)
                }
            }
    ) {
        Image(
            modifier = Modifier.fillMaxSize().borderRadius(10.px),
            src = src
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .borderRadius(10.px)
                .styleModifier {
                    property(
                        "background",
                        "linear-gradient(180deg, rgba(0, 0, 0, 0.00) 50.52%, rgba(0, 0, 0, 0.71) 100%)"
                    )
                }
        ) {
            Image(
                src = Res.Images.GITHUB_DARK_LOGO,
                modifier = Modifier.size(22.px)
                    .align(Alignment.BottomEnd)
                    .margin(bottom = 10.px, right = 10.px)
            )
        }
    }
}