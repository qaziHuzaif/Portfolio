package musaib.components.sections.footer.ui

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.toModifier
import musaib.components.sections.footer.components.DeveloperLocationInfoRow
import musaib.components.sections.footer.components.FooterContactRow
import musaib.components.sections.footer.components.GetInTouchColumn
import musaib.components.sections.footer.style.FooterStyle
import org.jetbrains.compose.web.css.cssRem


@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column (
        modifier = FooterStyle.toModifier()
            .fillMaxWidth()
            .id("contact")


    ){

        Column(
            modifier = modifier
                .fillMaxWidth()

        ) {

            GetInTouchColumn()

            FooterContactRow(modifier = modifier.padding { bottom(4.cssRem) })

            DeveloperLocationInfoRow()
        }




    }
}











