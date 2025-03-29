package musaib.components.sections.home.style

import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import musaib.components.styles.SectionContainerStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh

val HeroSectionStyle = SectionContainerStyle.extendedBy{


    Breakpoint.ZERO {
        Modifier
            .fontSize(2.5.cssRem)
            .height(100.vh)
    }
    Breakpoint.SM {
        Modifier
            .fontSize(2.5.cssRem)
            .height(100.vh)
    }
    Breakpoint.MD {
        Modifier
            .fontSize(2.75.cssRem)
            .height(100.vh)
    }
    Breakpoint.LG {
        Modifier

            .fontSize(3.cssRem)
            .height(100.vh)

    }
}

val HelloImStyle = CssStyle{


    Breakpoint.ZERO {
        Modifier.fontSize(FontSize.XXLarge)
    }

    Breakpoint.SM {
        Modifier.fontSize(FontSize.XXLarge)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.XLarge)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.XXLarge)
    }

    Breakpoint.XL {
        Modifier.fontSize(FontSize.XXLarge)
    }
}

val UserNameStyle = CssStyle {

    base {
        Modifier.fontSize(FontSize.Larger)
    }
}

val UsersMessageStyle = CssStyle {

    Breakpoint.ZERO {
        Modifier.fontSize(FontSize.XLarge)
    }

    Breakpoint.SM {
        Modifier.fontSize(FontSize.XLarge)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.Large)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.XXLarge)
    }

    Breakpoint.XL {
        Modifier.fontSize(FontSize.XXLarge)
    }
}