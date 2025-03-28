package musaib.components.sections.projects.components

import musaib.components.utils.Res
import musaib.components.utils.Res.Constants

fun getAllProjects() =
    listOf(
        Pair(Res.Images.PROJECT_FOUND_IT, Constants.FOUNT_IT_URL),
        Pair(Res.Images.PROJECT_RALITH_MILITH, Constants.RALITH_MILITH_URL),
        Pair(Res.Images.PROJECT_PORTFOLIO, Constants.PORTFOLIO_URL),
    )