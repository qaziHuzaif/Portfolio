package musaib.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import musaib.components.layouts.DefaultPageLayout
import musaib.components.sections.about.ui.About
import musaib.components.sections.home.ui.Home
import musaib.components.sections.projects.ui.Projects
import musaib.toSitePalette

@Page
@Composable
fun HomePage() {
    DefaultPageLayout("Musaib Shabir") {

        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            val currentPalette = ColorMode.current.toSitePalette()


            Home(currentPalette = currentPalette)

            About()

            Projects()
        }
    }

}

