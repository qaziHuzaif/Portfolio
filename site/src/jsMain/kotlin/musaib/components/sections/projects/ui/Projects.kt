package org.musaibshabir.portfolio.components.sections.projects.ui

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import musaib.components.SectionDiscriptionStyle
import org.musaibshabir.portfolio.components.sections.about.style.AboutStyle
import org.musaibshabir.portfolio.components.sections.projects.components.AppearanceAwareImage
import org.musaibshabir.portfolio.components.sections.projects.components.RoundedImage
import org.musaibshabir.portfolio.components.sections.projects.components.getAllProjects
import musaib.components.utils.Res
import musaib.components.utils.Res.Constants
import musaib.components.widgets.SectionTitle

@Composable
fun Projects() {
    Column (
        modifier = AboutStyle.toModifier().id("projects"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        SectionTitle(Res.Title.PROJECTS)

        SpanText(
            text = Constants.PROJECT_SECTION_TEXT,
            modifier = SectionDiscriptionStyle.toModifier()
                .textAlign(TextAlign.Center)
                .color(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.LightGray
                    }
                )
                //.fontFamily(Res.Fonts.DM_SANS)
        )

        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, md = 3),
            modifier = Modifier.fillMaxWidth().margin(top = 3.cssRem, bottom = 6.cssRem)
        ) {
            val allProjects = getAllProjects()

            repeat(allProjects.size) {
                val project = allProjects[it]
                RoundedImage(
                    src = project.first,
                    navigateTo = project.second
                )
            }

            Box(
                modifier = Modifier.fillMaxSize().padding(topBottom = 50.px),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Link(
                        path = Constants.PROJECT_REPOSITORIES_URL,
                        text = Constants.MORE_ON_GITHUB,
                        modifier = Modifier
                            //.fontFamily(Res.Fonts.DM_SANS)
                            .color(
                                when (ColorMode.current) {
                                    ColorMode.LIGHT -> Colors.Black
                                    ColorMode.DARK -> Colors.White
                                }
                            )
                            .margin(right = 4.px)
                    )
                    AppearanceAwareImage(
                        src = Res.Images.NAVIGATION_ARROW
                    )
                }
            }
        }

    }
}
