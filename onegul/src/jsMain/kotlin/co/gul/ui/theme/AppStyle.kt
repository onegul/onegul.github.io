package co.gul.ui.theme

import org.jetbrains.compose.web.css.*

object AppStyle : StyleSheet() {
    val navBar by style {
        position(Position.Fixed)
        top(0.px)
        left(0.px)
        right(0.px)
        property("z-index", 100)
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        justifyContent(JustifyContent.SpaceBetween)
        padding(0.px, Spacing.xl)
        height(64.px)
        backgroundColor(Palette.surface)
        property("border-bottom", "1px solid ${Palette.outlineVariant}")
        property("backdrop-filter", "blur(12px)")
        property("-webkit-backdrop-filter", "blur(12px)")
        property("background-color", "rgba(248,250,249,0.92)")
    }

    val navLogo by style {
        fontFamily(Font.DISPLAY)
        fontSize(22.px)
        fontWeight(600)
        color(Palette.onSurface)
        property("letter-spacing", "-0.02em")
        property("text-decoration", "none")
        cursor("pointer")
    }

    val navLinks by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        gap(Spacing.xs)
        listStyle("none")
    }

    val navLink by style {
        fontFamily(Font.BODY)
        fontSize(14.px)
        fontWeight(500)
        padding(Spacing.sm, Spacing.md)
        borderRadius(Radius.full)
        cursor("pointer")
        color(Palette.onSurfaceVariant)
        property("text-decoration", "none")
        property("transition", "all 0.2s ease")
        property("border", "none")
        property("background", "transparent")
        property("letter-spacing", "0.01em")
    }

    val navLinkActive by style {
        backgroundColor(Palette.secondaryContainer)
        color(Palette.secondary)
        fontWeight(600)
    }

    val pageWrapper by style {
        paddingTop(64.px)
        minHeight(100.vh)
        backgroundColor(Palette.surface)
    }

    // --- Home ------------------------------------------------------------------------------

    val heroHeading by style {
        fontFamily(Font.DISPLAY)
        property("font-size", "clamp(42px, 5.5vw, 72px)")
        fontWeight(300)
        lineHeight(1.1.em)
        color(Palette.onSurface)
        property("letter-spacing", "-0.02em")
    }

    val heroAccent by style {
        color(Palette.primary)
        fontStyle("italic")
    }

    val heroBody by style {
        fontFamily(Font.BODY)
        fontSize(17.px)
        lineHeight(1.75.em)
        color(Palette.onSurfaceVariant)
        marginTop(Spacing.lg)
    }

    val tag by style {
        fontFamily(Font.MONO)
        fontSize(12.px)
        fontWeight(400)
        padding(4.px, Spacing.md)
        borderRadius(Radius.full)
        backgroundColor(Palette.primaryContainer)
        color(Palette.onPrimaryContainer)
        property("letter-spacing", "0.03em")
    }

    val projectCard by style {
        backgroundColor(Palette.surfaceContainer)
        borderRadius(Radius.md)
        padding(Spacing.xl)
        border(1.px, LineStyle.Solid, Palette.outlineVariant)
        property("transition", "all 0.25s ease")
        cursor("default")
    }

    val projectCardTitle by style {
        fontFamily(Font.DISPLAY)
        fontSize(22.px)
        fontWeight(500)
        color(Palette.onSurface)
        property("letter-spacing", "-0.01em")
    }

    val projectCardBody by style {
        fontFamily(Font.BODY)
        fontSize(14.px)
        lineHeight(1.65.em)
        color(Palette.onSurfaceVariant)
        marginTop(Spacing.sm)
    }

    // --- Section Scaffold -------------------------------------------------------------------

    val sectionContainer by style {
        property("max-width", "900px")
        property("margin", "0 auto")
        padding(Spacing.xxxl, Spacing.xl)
    }

    val sectionHeading by style {
        fontFamily(Font.DISPLAY)
        property("font-size", "clamp(32px, 4vw, 52px)")
        fontWeight(300)
        color(Palette.onSurface)
        property("letter-spacing", "-0.02em")
        lineHeight(1.2.em)
    }

    val sectionSubheading by style {
        fontFamily(Font.BODY)
        fontSize(16.px)
        color(Palette.onSurfaceVariant)
        marginTop(Spacing.md)
        lineHeight(1.7.em)
    }

    val divider by style {
        height(1.px)
        backgroundColor(Palette.outlineVariant)
        border(0.px, LineStyle.None, Palette.outlineVariant)
        property("margin", "${Spacing.xxxl} 0")
    }

    // --- Resume ------------------------------------------------------------------------------

    val timeline by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Spacing.xl)
        marginTop(Spacing.xxl)
        position(Position.Relative)
    }

    val timelineCard by style {
        backgroundColor(Palette.surfaceContainer)
        borderRadius(Radius.md)
        padding(Spacing.xl)
        border(1.px, LineStyle.Solid, Palette.outlineVariant)
        position(Position.Relative)
        property("transition", "box-shadow 0.2s ease")
    }

    val roleCompany by style {
        fontFamily(Font.DISPLAY)
        fontSize(24.px)
        fontWeight(600)
        color(Palette.onSurface)
        property("letter-spacing", "-0.01em")
    }

    val roleTitle by style {
        fontFamily(Font.BODY)
        fontSize(15.px)
        fontWeight(500)
        color(Palette.primary)
        marginTop(Spacing.xs)
    }

    val rolePeriod by style {
        fontFamily(Font.MONO)
        fontSize(12.px)
        color(Palette.onSurfaceVariant)
        property("letter-spacing", "0.04em")
    }

    val roleSummary by style {
        fontFamily(Font.BODY)
        fontSize(15.px)
        lineHeight(1.7.em)
        color(Palette.onSurfaceVariant)
        marginTop(Spacing.md)
    }

    val roleHighlights by style {
        listStyle("none")
        marginTop(Spacing.md)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Spacing.sm)
    }

    val highlight by style {
        fontFamily(Font.BODY)
        fontSize(14.px)
        lineHeight(1.65.em)
        color(Palette.onSurface)
        paddingLeft(Spacing.md)
        position(Position.Relative)
    }

    val skillsGrid by style {
        display(DisplayStyle.Grid)
        property("grid-template-columns", "repeat(auto-fill, minmax(260px, 1fr))")
        gap(Spacing.md)
        marginTop(Spacing.lg)
    }

    val skillCard by style {
        backgroundColor(Palette.surfaceContainer)
        borderRadius(Radius.sm)
        padding(Spacing.lg)
        border(1.px, LineStyle.Solid, Palette.outlineVariant)
    }

    val skillCategory by style {
        fontFamily(Font.MONO)
        fontSize(11.px)
        fontWeight(400)
        color(Palette.primary)
        property("letter-spacing", "0.08em")
        property("text-transform", "uppercase")
        marginBottom(Spacing.sm)
    }

    val skillItems by style {
        property("list-style-type", "none")
        display(DisplayStyle.Flex)
        flexWrap(FlexWrap.Wrap)
        gap(Spacing.xs)
    }

    // --- Library --------------------------------------------------------------------------------------

    val bookGrid by style {
        display(DisplayStyle.Grid)
        property("grid-template-columns", "repeat(auto-fill, minmax(300px, 1fr))")
        gap(Spacing.lg)
        marginTop(Spacing.lg)
    }

    val bookCard by style {
        backgroundColor(Palette.surfaceContainer)
        borderRadius(Radius.md)
        padding(Spacing.lg)
        border(1.px, LineStyle.Solid, Palette.outlineVariant)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Spacing.sm)
        property("transition", "box-shadow 0.2s ease")
    }

    val bookTitle by style {
        fontFamily(Font.DISPLAY)
        fontSize(18.px)
        fontWeight(600)
        color(Palette.onSurface)
        lineHeight(1.3.em)
        property("letter-spacing", "-0.01em")
    }

    val bookAuthor by style {
        fontFamily(Font.BODY)
        fontSize(13.px)
        color(Palette.primary)
        fontWeight(500)
    }

    val bookNote by style {
        fontFamily(Font.BODY)
        fontSize(14.px)
        lineHeight(1.65.em)
        color(Palette.onSurfaceVariant)
        fontStyle("italic")
        property("flex", "1")
    }

    val bookStatus by style {
        fontFamily(Font.MONO)
        fontSize(11.px)
        padding(3.px, Spacing.sm)
        borderRadius(Radius.full)
        property("align-self", "flex-start")
        property("letter-spacing", "0.04em")
    }

    val statusRead by style {
        backgroundColor(Palette.primaryContainer)
        color(Palette.onPrimaryContainer)
    }

    val statusReading by style {
        backgroundColor(Palette.secondaryContainer)
        color(Palette.secondary)
    }

    val statusWant by style {
        backgroundColor(Palette.surfaceVariant)
        color(Palette.onSurfaceVariant)
    }

    // --- Notebook -------------------------------------------------------------------------

    val noteList by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        gap(Spacing.lg)
        marginTop(Spacing.lg)
    }

    val noteCard by style {
        backgroundColor(Palette.surfaceContainer)
        borderRadius(Radius.md)
        padding(Spacing.xl)
        border(1.px, LineStyle.Solid, Palette.outlineVariant)
        cursor("pointer")
        property("transition", "all 0.2s ease")
    }

    val noteTitle by style {
        fontFamily(Font.DISPLAY)
        fontSize(22.px)
        fontWeight(500)
        color(Palette.onSurface)
        lineHeight(1.3.em)
        property("letter-spacing", "-0.01em")
    }

    val noteMeta by style {
        fontFamily(Font.MONO)
        fontSize(12.px)
        color(Palette.onSurfaceVariant)
        marginTop(Spacing.xs)
        property("letter-spacing", "0.03em")
    }

    val noteExcerpt by style {
        fontFamily(Font.BODY)
        fontSize(14.px)
        lineHeight(1.7.em)
        color(Palette.onSurfaceVariant)
        marginTop(Spacing.md)
    }

    val noteBody by style {
        fontFamily(Font.BODY)
        fontSize(15.px)
        lineHeight(1.8.em)
        color(Palette.onSurface)
        marginTop(Spacing.lg)
        whiteSpace("pre-wrap")
    }

    val noteTag by style {
        fontFamily(Font.MONO)
        fontSize(11.px)
        padding(3.px, Spacing.sm)
        borderRadius(Radius.full)
        property("letter-spacing", "0.04em")
    }

    val noteTech by style {
        backgroundColor(Palette.primaryContainer)
        color(Palette.onPrimaryContainer)
    }

    val noteObs by style {
        backgroundColor(Palette.secondaryContainer)
        color(Palette.secondary)
    }

    val noteIdea by style {
        backgroundColor(Palette.surfaceVariant)
        color(Palette.onSurfaceVariant)
    }

    val noteDraft by style {
        backgroundColor(Palette.surfaceVariant)
        color(Palette.onSurfaceVariant)
    }

    // --- Buttons -----------------------------------------------------------------------

    val btnPrimary by style {
        fontFamily(Font.BODY)
        fontSize(14.px)
        fontWeight(500)
        padding(Spacing.md, Spacing.xl)
        borderRadius(Radius.full)
        backgroundColor(Palette.primary)
        color(Palette.onPrimary)
        border(0.px, LineStyle.None, Palette.primary)
        cursor("pointer")
        property("transition", "all 0.2s ease")
        property("letter-spacing", "0.01em")
        property("text-decoration", "none")
        display(DisplayStyle.InlineBlock)
    }

    val btnOutline by style {
        fontFamily(Font.BODY)
        fontSize(14.px)
        fontWeight(500)
        padding(Spacing.md, Spacing.xl)
        borderRadius(Radius.full)
        property("background-color", "transparent")
        color(Palette.primary)
        border(1.px, LineStyle.Solid, Palette.primary)
        cursor("pointer")
        property("transition", "all 0.2s ease")
        property("letter-spacing", "0.01em")
        property("text-decoration", "none")
        display(DisplayStyle.InlineBlock)
    }


    // --- Footer -------------------------------------------------------------------------------

    val footer by style {
        padding(Spacing.xl)
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
        property("max-width", "1200px")
        property("margin", "0 auto")
    }

    val footerText by style {
        fontFamily(Font.MONO)
        fontSize(12.px)
        color(Palette.onSurfaceVariant)
        property("letter-spacing", "0.04em")
    }


    // --- Animations -----------------------------------------------------------------------------

    val fadeIn by keyframes {
        from { property("opacity", "0"); property("transform", "translateY(16px)") }
        to { property("opacity", "1"); property("transform", "translateY(0)") }
    }
}