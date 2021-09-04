package reakt

import react.ElementType
import react.ReactElement

external interface FoldIconProps {
    val collapsed: Boolean
    val header: String
    val icon: String
    val onClick: () -> Unit
}

external interface FoldableTableProps<D> : TableProps<D> {
    var FoldIconComponent: (FoldIconProps) -> ReactElement
    var FoldButtonComponent: (FoldIconProps) -> ReactElement
}

@JsModule("react-table/lib/hoc/foldableTable")
@JsNonModule
internal external object ReactFoladableTable {
    @JsName("default")
    fun <D> foldableTableHOC(clazz: JsClass<ReactTableModule.ReactTable<*>>): ElementType<FoldableTableProps<D>>
}