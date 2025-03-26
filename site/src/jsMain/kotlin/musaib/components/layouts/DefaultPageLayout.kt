package musaib.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import kotlinx.browser.document
import musaib.components.sections.Footer
import musaib.components.sections.NavHeader

@Composable
fun DefaultPageLayout(
    title: String,
    content: @Composable () -> Unit,
) {
    LaunchedEffect(title) {
        document.title = "Musaib Shabir - $title"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(leftRight = 2.cssRem)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NavHeader()
        content()
        Footer()
    }
}