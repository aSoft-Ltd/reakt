@file:JsModule("enzyme")
@file:JsNonModule

package ui.enzyme

import kotlinext.js.jsObject
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import react.*
import kotlin.js.Json
import kotlin.js.RegExp

external interface EnzymeAdapter

external interface EnzymeConfig {
    var adapter: EnzymeAdapter
}

external fun configure(config: EnzymeConfig)

external fun shallow(el: ReactElement): ShallowWrapper

external fun mount(el: ReactElement): MountWrapper

external interface ShallowWrapper : CommonWrapper {
    //    open fun shallow(options: ShallowRendererProps = definedExternally): ShallowWrapper
//    open fun unmount(): ShallowWrapper<P, S, C> /* this */
//    open fun <P2> find(statelessComponent: StatelessComponent<P2>): ShallowWrapper__2<P2, Any>
//    open fun <P2> find(component: ComponentClass<P2>): ShallowWrapper__2<P2, Any>
//    open fun <C2 : Component__0> find(componentClass: ComponentClass<Any>): ShallowWrapper<Any, Any, C2>
//    open fun find(props: EnzymePropSelector): ShallowWrapper__2<Any, Any>
    fun find(selector: String): ShallowWrapper
//    open fun <P2> filter(statelessComponent: StatelessComponent<P2>): ShallowWrapper__2<P2, Any>
//    open fun <P2> filter(component: ComponentClass<P2>): ShallowWrapper__2<P2, Any>
//    open fun filter(props: EnzymePropSelector): ShallowWrapper__2<P, S>
//    open fun filter(props: String): ShallowWrapper__2<P, S>
//    open fun findWhere(predicate: (wrapper: ShallowWrapper__2<Any, Any>) -> Boolean): ShallowWrapper__2<Any, Any>
//    open fun <P2> children(statelessComponent: StatelessComponent<P2>): ShallowWrapper__2<P2, Any>
//    open fun <P2> children(component: ComponentClass<P2>): ShallowWrapper__2<P2, Any>
//    open fun children(selector: String): ShallowWrapper__2<AllHTMLAttributes<Any> /* ReactHTMLAttributes<Any> & ReactSVGAttributes<Any> */, Any>
//    open fun children(props: EnzymePropSelector = definedExternally): ShallowWrapper__2<Any, Any>
//    open fun children(): ShallowWrapper__2<Any, Any>
//    open fun childAt(index: Number): ShallowWrapper__2<Any, Any>
//    open fun <P2, S2> childAt(index: Number): ShallowWrapper__2<P2, S2>
//    open fun <C2 : Component__0, P2, S2> dive(options: ShallowRendererProps = definedExternally): ShallowWrapper<P2, S2, C2>
//    open fun <C2 : Component__0, P2, S2> dive(): ShallowWrapper<P2, S2, C2>
//    open fun <P2, S2> dive(options: ShallowRendererProps = definedExternally): ShallowWrapper__2<P2, S2>
//    open fun <P2, S2> dive(): ShallowWrapper__2<P2, S2>
//    open fun <P2, S2, C2> dive(options: ShallowRendererProps = definedExternally): ShallowWrapper<P2, S2, C2>
//    open fun <P2, S2, C2> dive(): ShallowWrapper<P2, S2, C2>
//    open fun hostNodes(): ShallowWrapper__1<AllHTMLAttributes<Any> /* ReactHTMLAttributes<Any> & ReactSVGAttributes<Any> */>
//    open fun <P2> parents(statelessComponent: StatelessComponent<P2>): ShallowWrapper__2<P2, Any>
//    open fun <P2> parents(component: ComponentClass<P2>): ShallowWrapper__2<P2, Any>
//    open fun parents(selector: String): ShallowWrapper__2<AllHTMLAttributes<Any> /* ReactHTMLAttributes<Any> & ReactSVGAttributes<Any> */, Any>
//    open fun parents(props: EnzymePropSelector = definedExternally): ShallowWrapper__2<Any, Any>
//    open fun parents(): ShallowWrapper__2<Any, Any>
//    open fun <P2> closest(statelessComponent: StatelessComponent<P2>): ShallowWrapper__2<P2, Any>
//    open fun <P2> closest(component: ComponentClass<P2>): ShallowWrapper__2<P2, Any>
//    open fun closest(props: EnzymePropSelector): ShallowWrapper__2<Any, Any>
//    open fun closest(selector: String): ShallowWrapper__2<AllHTMLAttributes<Any> /* ReactHTMLAttributes<Any> & ReactSVGAttributes<Any> */, Any>
//    open fun parent(): ShallowWrapper__2<Any, Any>
//    open fun <PropName : Any> renderProp(prop: PropName): (params: Parameters<Any>) -> ShallowWrapper__2<Any, Any>
//    open var getWrappingComponent: () -> ShallowWrapper__0
}

external interface MountWrapper : CommonWrapper

external interface Cheerio {
    @nativeGetter
    operator fun get(index: Number): dynamic /* Element | Any */

    @nativeSetter
    operator fun set(index: Number, value: Element)
    var cheerio: String
    var length: Number
    fun attr(name: String): String?
    fun attr(name: String, value: String): Cheerio
    fun attr(map: Json): Cheerio
    fun data(): Any
    fun data(name: String): Any
    fun data(name: String, value: Any): Any
    fun `val`(): String
    fun `val`(value: String): Cheerio
    fun removeAttr(name: String): Cheerio
    fun has(selector: String): Cheerio
    fun has(element: Element): Cheerio
    fun hasClass(className: String): Boolean
    fun addClass(classNames: String): Cheerio
    fun removeClass(): Cheerio
    fun removeClass(className: String): Cheerio
    fun removeClass(func: (index: Number, className: String) -> String): Cheerio
    fun toggleClass(className: String): Cheerio
    fun toggleClass(className: String, toggleSwitch: Boolean): Cheerio
    fun toggleClass(toggleSwitch: Boolean = definedExternally): Cheerio
    fun toggleClass(): Cheerio
    fun toggleClass(func: (index: Number, className: String, toggleSwitch: Boolean) -> String, toggleSwitch: Boolean = definedExternally): Cheerio
    fun toggleClass(func: (index: Number, className: String, toggleSwitch: Boolean) -> String): Cheerio
    fun `is`(selector: String): Boolean
    fun `is`(element: Element): Boolean
    fun `is`(element: Array<Element>): Boolean
    fun `is`(selection: Cheerio): Boolean
    fun `is`(func: (index: Number, element: Element) -> Boolean): Boolean
    fun serialize(): String
    fun find(selector: String): Cheerio
    fun find(element: Cheerio): Cheerio
    fun parent(selector: String = definedExternally): Cheerio
    fun parents(selector: String = definedExternally): Cheerio
    fun parentsUntil(selector: String = definedExternally, filter: String = definedExternally): Cheerio
    fun parentsUntil(): Cheerio
    fun parentsUntil(selector: String = definedExternally): Cheerio
    fun parentsUntil(element: Element, filter: String = definedExternally): Cheerio
    fun parentsUntil(element: Element): Cheerio
    fun parentsUntil(element: Cheerio, filter: String = definedExternally): Cheerio
    fun parentsUntil(element: Cheerio): Cheerio
    fun prop(name: String): Any
    fun prop(name: String, value: Any): Cheerio
    fun closest(): Cheerio
    fun closest(selector: String): Cheerio
    fun next(selector: String = definedExternally): Cheerio
    fun nextAll(): Cheerio
    fun nextAll(selector: String): Cheerio
    fun nextUntil(selector: String = definedExternally, filter: String = definedExternally): Cheerio
    fun nextUntil(): Cheerio
    fun nextUntil(selector: String = definedExternally): Cheerio
    fun nextUntil(element: Element, filter: String = definedExternally): Cheerio
    fun nextUntil(element: Element): Cheerio
    fun nextUntil(element: Cheerio, filter: String = definedExternally): Cheerio
    fun nextUntil(element: Cheerio): Cheerio
    fun prev(selector: String = definedExternally): Cheerio
    fun prevAll(): Cheerio
    fun prevAll(selector: String): Cheerio
    fun prevUntil(selector: String = definedExternally, filter: String = definedExternally): Cheerio
    fun prevUntil(): Cheerio
    fun prevUntil(selector: String = definedExternally): Cheerio
    fun prevUntil(element: Element, filter: String = definedExternally): Cheerio
    fun prevUntil(element: Element): Cheerio
    fun prevUntil(element: Cheerio, filter: String = definedExternally): Cheerio
    fun prevUntil(element: Cheerio): Cheerio
    fun slice(start: Number, end: Number = definedExternally): Cheerio
    fun siblings(selector: String = definedExternally): Cheerio
    fun children(selector: String = definedExternally): Cheerio
    fun contents(): Cheerio
    fun each(func: (index: Number, element: Element) -> Any): Cheerio
    fun map(func: (index: Number, element: Element) -> Any): Cheerio
    fun filter(selector: String): Cheerio
    fun filter(selection: Cheerio): Cheerio
    fun filter(element: Element): Cheerio
    fun filter(elements: Array<Element>): Cheerio
    fun filter(func: (index: Number, element: Element) -> Boolean): Cheerio
    fun not(selector: String): Cheerio
    fun not(selection: Cheerio): Cheerio
    fun not(element: Element): Cheerio
    fun not(func: (index: Number, element: Element) -> Boolean): Cheerio
    fun first(): Cheerio
    fun last(): Cheerio
    fun eq(index: Number): Cheerio
    fun get(): Array<Any>
    fun index(): Number
    fun index(selector: String): Number
    fun index(selection: Cheerio): Number
    fun end(): Cheerio
    fun add(selectorOrHtml: String): Cheerio
    fun add(selector: String, context: Document): Cheerio
    fun add(element: Element): Cheerio
    fun add(elements: Array<Element>): Cheerio
    fun add(selection: Cheerio): Cheerio
    fun addBack(): Cheerio
    fun addBack(filter: String): Cheerio
    fun appendTo(target: Cheerio): Cheerio
    fun prependTo(target: Cheerio): Cheerio
    fun append(content: String, vararg contents: Any): Cheerio
    fun append(content: Document, vararg contents: Any): Cheerio
    fun append(content: Array<Document>, vararg contents: Any): Cheerio
    fun append(content: Cheerio, vararg contents: Any): Cheerio
    fun prepend(content: String, vararg contents: Any): Cheerio
    fun prepend(content: Document, vararg contents: Any): Cheerio
    fun prepend(content: Array<Document>, vararg contents: Any): Cheerio
    fun prepend(content: Cheerio, vararg contents: Any): Cheerio
    fun after(content: String, vararg contents: Any): Cheerio
    fun after(content: Document, vararg contents: Any): Cheerio
    fun after(content: Array<Document>, vararg contents: Any): Cheerio
    fun after(content: Cheerio, vararg contents: Any): Cheerio
    fun insertAfter(content: String): Cheerio
    fun insertAfter(content: Document): Cheerio
    fun insertAfter(content: Cheerio): Cheerio
    fun before(content: String, vararg contents: Any): Cheerio
    fun before(content: Document, vararg contents: Any): Cheerio
    fun before(content: Array<Document>, vararg contents: Any): Cheerio
    fun before(content: Cheerio, vararg contents: Any): Cheerio
    fun insertBefore(content: String): Cheerio
    fun insertBefore(content: Document): Cheerio
    fun insertBefore(content: Cheerio): Cheerio
    fun remove(selector: String = definedExternally): Cheerio
    fun replaceWith(content: String): Cheerio
    fun replaceWith(content: ReactElement): Cheerio
    fun replaceWith(content: Array<ReactElement>): Cheerio
    fun replaceWith(content: Cheerio): Cheerio
    fun replaceWith(content: () -> Cheerio): Cheerio
    fun empty(): Cheerio
    fun html(): String?
    fun html(html: String): Cheerio
    fun text(): String
    fun text(text: String): Cheerio
    fun wrap(content: String): Cheerio
    fun wrap(content: Document): Cheerio
    fun wrap(content: Cheerio): Cheerio
    fun css(propertyName: String): String
    fun css(propertyNames: Array<String>): Array<String>
    fun css(propertyName: String, value: String): Cheerio
    fun css(propertyName: String, value: Number): Cheerio
    fun css(propertyName: String, func: (index: Number, value: String) -> String): Cheerio
    fun css(propertyName: String, func: (index: Number, value: String) -> Number): Cheerio
    fun css(properties: Any): Cheerio
    fun clone(): Cheerio
    fun toArray(): Array<ReactElement>
}

external interface CommonWrapper {
    fun filterWhere(predicate: (wrapper: CommonWrapper /* this */) -> Boolean): CommonWrapper /* this */
    fun contains(node: ReactElement): Boolean
    fun contains(node: Array<ReactElement>): Boolean
    fun contains(node: String): Boolean
    fun contains(node: Number): Boolean
    fun containsMatchingElement(node: ReactElement): Boolean
    fun containsMatchingElement(node: Array<ReactElement>): Boolean
    fun containsAllMatchingElements(nodes: Array<ReactElement>): Boolean
    fun containsAllMatchingElements(nodes: Array<Array<ReactElement>>): Boolean
    fun containsAnyMatchingElements(nodes: Array<ReactElement>): Boolean
    fun containsAnyMatchingElements(nodes: Array<Array<ReactElement>>): Boolean
    fun equals(node: ReactElement): Boolean
    fun matchesElement(node: ReactElement): Boolean
    fun hasClass(className: String): Boolean
    fun hasClass(className: RegExp): Boolean
    fun <K : Any> invoke(invokePropName: K): Any
    fun `is`(selector: String): Boolean
    fun `is`(selector: FunctionalComponent<*>): Boolean
    fun `is`(selector: Component<*, *>): Boolean
    fun isEmpty(): Boolean
    fun exists(selector: String = definedExternally): Boolean
    fun exists(): Boolean
    fun exists(selector: FunctionalComponent<*> = definedExternally): Boolean
    fun exists(selector: Component<*, *> = definedExternally): Boolean
    fun not(selector: String): CommonWrapper /* this */
    fun not(selector: FunctionalComponent<*>): CommonWrapper /* this */
    fun not(selector: Component<*, *>): CommonWrapper /* this */
    fun text(): String
    fun html(): String
    fun get(index: Number): ReactElement
    fun getNode(): ReactElement
    fun getNodes(): Array<ReactElement>
    fun getElement(): ReactElement
    fun getElements(): Array<ReactElement>
    fun <T : HTMLElement> getDOMNode(): T
    fun at(index: Number): CommonWrapper /* this */
    fun first(): CommonWrapper /* this */
    fun last(): CommonWrapper /* this */
    fun slice(begin: Number = definedExternally, end: Number = definedExternally): CommonWrapper /* this */
    fun <S> state(key: String): S
    fun <S> state(): S
    fun context(): Any
    fun <T> context(key: String): T
    fun <P> props(): P
    fun <K : Any> prop(key: K): Any
    fun <T> prop(key: String): T
    fun key(): String
    fun simulate(event: String, vararg args: Any): CommonWrapper /* this */
    fun simulateError(error: Any): CommonWrapper /* this */
    fun setState(state: Any, callback: () -> Unit = definedExternally): CommonWrapper /* this */
    fun setProps(props: Any, callback: () -> Unit = definedExternally): CommonWrapper /* this */
    fun setContext(context: Any): CommonWrapper /* this */
    fun <C> instance(): C
    fun update(): CommonWrapper /* this */
    fun debug(options: dynamic = definedExternally): String
    fun name(): String
    fun forEach(fn: (wrapper: CommonWrapper /* this */, index: Number) -> Any): CommonWrapper /* this */
    fun <V> map(fn: (wrapper: CommonWrapper /* this */, index: Number) -> V): Array<V>
    fun <R> reduce(fn: (prevVal: R, wrapper: CommonWrapper /* this */, index: Number) -> R, initialValue: R = definedExternally): R
    fun <R> reduceRight(fn: (prevVal: R, wrapper: CommonWrapper /* this */, index: Number) -> R, initialValue: R = definedExternally): R
    fun some(selector: String): Boolean
    fun some(selector: FunctionalComponent<*>): Boolean
    fun some(selector: Component<*, *>): Boolean
    fun someWhere(fn: (wrapper: CommonWrapper /* this */) -> Boolean): Boolean
    fun every(selector: String): Boolean
    fun every(selector: FunctionalComponent<*>): Boolean
    fun every(selector: Component<*, *>): Boolean
    fun everyWhere(fn: (wrapper: CommonWrapper /* this */) -> Boolean): Boolean
    fun isEmptyRender(): Boolean
    fun render(): Cheerio
    fun type(): dynamic /* String | Component<*,*><P> | FunctionalComponent<*><P> */
    var length: Number
}