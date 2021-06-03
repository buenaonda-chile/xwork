/*!
    *
    * Wijmo Library 5.20202.732
    * http://wijmo.com/
    *
    * Copyright(c) GrapeCity, Inc.  All rights reserved.
    *
    * Licensed under the GrapeCity Commercial License.
    * sales@wijmo.com
    * wijmo.com/products/wijmo-5/license/
    *
    */
declare module wijmo.vue2 {
    function softInput(): typeof wijmo.input;
    function softGridDetail(): typeof wijmo.grid.detail;
}
declare module wijmo.vue2 {
    abstract class DirectiveCellFactoryBase extends wijmo.grid.CellFactory {
        private static _templateTypes;
        private static _cellStampProp;
        private static _FOCUS_INTERVAL;
        grid: wijmo.grid.FlexGrid;
        private _baseCf;
        private _closingApplyTimeOut;
        private _lastApplyTimeStamp;
        private _noApplyLag;
        private _editChar;
        private _startingEditing;
        private _evtInput;
        private _evtBlur;
        private _cellStampCounter;
        private _cellEditorVars;
        private _composing;
        constructor(grid: wijmo.grid.FlexGrid);
        updateCell(panel: wijmo.grid.GridPanel, rowIndex: number, colIndex: number, cell: HTMLElement, rng?: wijmo.grid.CellRange): void;
        getEditorValue(g: wijmo.grid.FlexGrid): any;
        disposeCell(cell: HTMLElement): void;
        /**
         * Indicates whether a new template instance must be created for the cell.
         * @param cell
         * @param templContextProp
         */
        protected abstract shouldInstantiate(cellInfo: ICellRenderingInfo): boolean;
        protected abstract renderTemplate(cellInfo: ICellRenderingInfo, initNew: boolean): any;
        protected disposeTemplate(cell: HTMLElement, templateCache: ICellTemplateCache, templateContext: ICellTemplateInfo): void;
        /**
         * Forces template to apply all changes immediately (apply bindings, etc - whatever is relevant),
         * to make its size up to date. Usually used in cell size measurement scenarios.
         * @param cellInfo
         */
        protected abstract applyImmediately(cellInfo: ICellRenderingInfo): any;
        /**
         * Causes the control to immediately trigger pending framework events.
         * @param control
         */
        protected abstract flushPendingEvents(control: wijmo.Control): any;
        protected abstract getEditorFocusFlag(): boolean;
        protected abstract setEditorFocusFlag(value: boolean): any;
        protected setBindingsData(context: any, row: wijmo.grid.Row, col: wijmo.grid.Column, dataItem: any, cellValue: any, valuePaths: Object): CellBindingsData;
        protected checkHeight(cellInfo: ICellRenderingInfo): void;
        protected doDisposeCell(cell: HTMLElement): void;
        protected abstract clearCell(cell: HTMLElement): any;
        static getTemplContextProp(templateType: GridCellTemplateType): string;
        private _doDisposeCell;
        private _initEditInput;
        private _initImeEditInput;
        private _findInitialInput;
        private static _setSelectionRange;
        private _triggerEditorEvents;
        private _isFullEdit;
        private _setFullEdit;
    }
    /**
    * Defines the type of cell on which a template is to be applied. This value is specified in the <b>cellType</b> attribute
    * of the frameworks' cell template components/directives.
    */
    enum GridCellTemplateType {
        /** Defines a regular (data) cell. */
        Cell = 0,
        /** Defines a cell in edit mode. */
        CellEdit = 1,
        /** Defines a column header cell. */
        ColumnHeader = 2,
        /** Defines a row header cell. */
        RowHeader = 3,
        /** Defines a row header cell in edit mode. */
        RowHeaderEdit = 4,
        /** Defines a top left cell. */
        TopLeft = 5,
        /** Defines a group header cell in a group row. */
        GroupHeader = 6,
        /** Defines a regular cell in a group row. */
        Group = 7,
        /** Defines a cell in a new row template. */
        NewCellTemplate = 8,
        /** Defines a column footer cell. */
        ColumnFooter = 9,
        /** Defines a bottom left cell (at the intersection of the row header and column footer cells). **/
        BottomLeft = 10
    }
    interface ICellTemplateInfo {
        cellOverflow: string;
        autoSizeRows: boolean;
        forceFullEdit: boolean;
        valuePaths: Object;
    }
    interface ICellTemplateCache {
        column?: wijmo.grid.Column;
        templateContextProperty: string;
        rootElement: Element;
    }
    interface ICellRenderingInfo {
        cell: HTMLElement;
        column: wijmo.grid.Column;
        row: wijmo.grid.Row;
        cellValue: any;
        panel: wijmo.grid.GridPanel;
        rng: wijmo.grid.CellRange;
        isEdit: boolean;
        isImeInput: boolean;
        isTrueImeInput: boolean;
        templateContextProperty: string;
        templateContext: ICellTemplateInfo;
        templateCache: ICellTemplateCache;
        cellBindingsData?: CellBindingsData;
        cellStamp: number;
    }
    interface CellBindingsData {
        localVars: {
            row: any;
            col: any;
            item: any;
            value: any;
            values: any;
        };
        bindings?: any;
    }
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    var VueApi: any;
    class WjComponentBehavior {
        static tag: string;
        static render: (createElement: () => any) => any;
        static className: string;
        static classCtor: () => any;
        static parentProp: string;
        static parentInCtor: boolean;
        static siblingId: string;
        static data: any;
        static props: string[];
        static events: string[];
        static changeEvents: {
            [event: string]: string[];
        };
        static modelProp: string;
        private static readonly _typeSiblingIdAttr;
        static readonly _behClassProp: string;
        static readonly _behProp: string;
        static readonly _propIdxMapProp: string;
        private static _siblingDirId;
        private static _modelEvent;
        private _siblingId;
        private _isMounted;
        private _mountedCBs;
        private _siblingInsertedEH;
        readonly component: any;
        control: any;
        parent: WjComponentBehavior;
        ['constructor']: typeof WjComponentBehavior;
        static _attach(component: any): WjComponentBehavior;
        static register(): any;
        constructor(component: any);
        lhMounted(): void;
        lhDestroyed(): void;
        private static _getProps;
        private static _getModel;
        private static _getEmits;
        protected _createControl(): any;
        protected _initParent(): void;
        protected _updateControl(property: string, newValue: any): void;
        private _prepareControl;
        private _isChild;
        private _isParentInCtor;
        private _getParentProp;
        private _getSiblingIndex;
        private _siblingInserted;
        private _getElement;
        private static _getControlType;
        _mountedCB(cb: () => void): void;
    }
    function _initialize(behavior: WjComponentBehavior): any;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.TrendLine} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartTrendLine: any;
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.MovingAverage} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartMovingAverage: any;
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.YFunctionSeries} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartYFunctionSeries: any;
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.ParametricFunctionSeries} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartParametricFunctionSeries: any;
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.Waterfall} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartWaterfall: any;
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.BoxWhisker} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartBoxWhisker: any;
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.ErrorBar} in a {@link wijmo.vue2.chart.WjFlexChart}.
     */
    var WjFlexChartErrorBar: any;
    /**
     * Vue component that represents a {@link wijmo.chart.analytics.BreakEven} in a {@link wijmo.vue2.chart.WjFlexChart}.
     */
    var WjFlexChartBreakEven: any;
    function registerChartAnalytics(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that represents a {@link wijmo.chart.animation.ChartAnimation} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     * , {@link wijmo.vue2.chart.WjFlexPie}
     * , {@link wijmo.vue2.chart.finance.WjFinancialChart}
     *  or {@link wijmo.vue2.chart.radar.WjFlexRadar}.
     */
    var WjFlexChartAnimation: any;
    function registerChartAnimation(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.AnnotationLayer} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartAnnotationLayer: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Text} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationText: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Ellipse} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationEllipse: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Rectangle} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationRectangle: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Line} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationLine: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Polygon} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationPolygon: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Circle} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationCircle: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Square} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationSquare: any;
    /**
     * Vue component that represents a {@link wijmo.chart.annotation.Image} in a {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLayer}.
     */
    var WjFlexChartAnnotationImage: any;
    function registerChartAnnotation(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.Fibonacci} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartFibonacci: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.FibonacciArcs} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartFibonacciArcs: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.FibonacciFans} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartFibonacciFans: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.FibonacciTimeZones} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartFibonacciTimeZones: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.ATR} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartAtr: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.CCI} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartCci: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.RSI} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartRsi: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.WilliamsR} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartWilliamsR: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.Macd} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartMacd: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.MacdHistogram} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartMacdHistogram: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.Stochastic} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartStochastic: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.BollingerBands} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartBollingerBands: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.analytics.Envelopes} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartEnvelopes: any;
    function registerChartFinanceAnalytics(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.chart.finance.FinancialChart} control.
     */
    var WjFinancialChart: any;
    /**
     * Vue component that represents a {@link wijmo.chart.finance.FinancialSeries} in a {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFinancialChartSeries: any;
    function registerChartFinance(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.chart.hierarchical.Sunburst} control.
     */
    var WjSunburst: any;
    /**
     * Vue component that encapsulates the {@link wijmo.chart.hierarchical.TreeMap} control.
     */
    var WjTreeMap: any;
    function registerChartHierarchical(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that represents a {@link wijmo.chart.interaction.RangeSelector} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartRangeSelector: any;
    /**
     * Vue component that represents a {@link wijmo.chart.interaction.ChartGestures} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartGestures: any;
    function registerChartInteraction(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.chart.radar.FlexRadar} control.
     */
    var WjFlexRadar: any;
    /**
     * Vue component that represents a {@link wijmo.chart.radar.FlexRadarAxis} in one of the following components:
     * {@link wijmo.vue2.chart.radar.WjFlexRadar}
     *  or {@link wijmo.vue2.chart.radar.WjFlexRadarSeries}.
     */
    var WjFlexRadarAxis: any;
    /**
     * Vue component that represents a {@link wijmo.chart.radar.FlexRadarSeries} in a {@link wijmo.vue2.chart.radar.WjFlexRadar}.
     */
    var WjFlexRadarSeries: any;
    function registerChartRadar(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.chart.FlexChart} control.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.chart.FlexChart} control using Vue markup:
     *
     * <pre>&lt;wj-flex-chart
     *     :items-source="data"
     *     binding-x="country"
     *     :header="props.header"
     *     :footer="props.footer"&gt;
     *
     *     &lt;wj-flex-chart-legend :position="props.legendPosition"&gt;
     *     &lt;/wj-flex-chart-legend&gt;
     *     &lt;wj-flex-chart-axis wj-property="axisX" :title="props.titleX"&gt;
     *     &lt;/wj-flex-chart-axis&gt;
     *     &lt;wj-flex-chart-axis wj-property="axisY" :title="props.titleY"&gt;
     *     &lt;/wj-flex-chart-axis&gt;
     *
     *     &lt;wj-flex-chart-series name="Sales" binding="sales"&gt;
     *     &lt;/wj-flex-chart-series&gt;
     *     &lt;wj-flex-chart-series name="Expenses" binding="expenses"&gt;
     *     &lt;/wj-flex-chart-series&gt;
     *     &lt;wj-flex-chart-series name="Downloads" binding="downloads"&gt;
     *     &lt;/wj-flex-chart-series&gt;
     * &lt;/wj-flex-chart&gt;</pre>
     *
     * The code sets the <b>itemsSource</b> property to a collection that contains the chart
     * data and the <b>bindingX</b> property to the data property that contains the chart X values.
     * It also sets the chart's <b>header</b> and <b>footer</b> properties to define titles to
     * show above and below the chart.
     *
     * The <b>wj-flex-chart-legend</b> and <b>wj-flex-chart-axis</b> components are used to
     * customize the chart's legend and axes.
     *
     * Finally, three <b>wj-flex-chart-series</b> components are used to specify the data
     * properties to be shown on the chart.
     */
    var WjFlexChart: any;
    /**
     * Vue component that encapsulates the {@link wijmo.chart.FlexPie} control.
     */
    var WjFlexPie: any;
    /**
     * Vue component that represents a {@link wijmo.chart.Axis} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     * , {@link wijmo.vue2.chart.WjFlexChartSeries}
     * , {@link wijmo.vue2.chart.finance.WjFinancialChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChartSeries}.
     */
    var WjFlexChartAxis: any;
    /**
     * Vue component that represents a {@link wijmo.chart.Legend} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     * , {@link wijmo.vue2.chart.WjFlexPie}
     * , {@link wijmo.vue2.chart.finance.WjFinancialChart}
     * , {@link wijmo.vue2.chart.radar.WjFlexRadar}
     *  or {@link wijmo.vue2.chart.hierarchical.WjSunburst}.
     */
    var WjFlexChartLegend: any;
    /**
     * Vue component that represents a {@link wijmo.chart.DataLabel} in a {@link wijmo.vue2.chart.WjFlexChart}.
     */
    var WjFlexChartDataLabel: any;
    /**
     * Vue component that represents a {@link wijmo.chart.PieDataLabel} in a {@link wijmo.vue2.chart.WjFlexPie}.
     */
    var WjFlexPieDataLabel: any;
    /**
     * Vue component that represents a {@link wijmo.chart.Series} in a {@link wijmo.vue2.chart.WjFlexChart}.
     */
    var WjFlexChartSeries: any;
    /**
     * Vue component that represents a {@link wijmo.chart.LineMarker} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartLineMarker: any;
    /**
     * Vue component that represents a {@link wijmo.chart.DataPoint} in one of the following components:
     * {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationText}
     * , {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationEllipse}
     * , {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationRectangle}
     * , {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationLine}
     * , {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationPolygon}
     * , {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationCircle}
     * , {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationSquare}
     *  or {@link wijmo.vue2.chart.annotation.WjFlexChartAnnotationImage}.
     */
    var WjFlexChartDataPoint: any;
    /**
     * Vue component that represents a {@link wijmo.chart.PlotArea} in one of the following components:
     * {@link wijmo.vue2.chart.WjFlexChart}
     *  or {@link wijmo.vue2.chart.finance.WjFinancialChart}.
     */
    var WjFlexChartPlotArea: any;
    function registerChart(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that includes a given HTML fragment into the document.
     *
     * The <b>wj-include</b> component takes a <b>src</b> attribute that
     * specifies a file to load and include into the document. For example:
     *
     * <pre>&lt;wj-popup control="modalDialog" :modal="true" :hide-trigger="None"&gt;
     *   &lt;wj-include src="includes/dialog.htm"&gt;&lt;/wj-include&gt;
     * &lt;/wj-popup&gt;</pre>
     */
    var WjInclude: any;
    var wjFormat: (value: any, format: any) => string;
    /**
     * Vue filter that applies globalized formatting to dates and numbers.
     *
     * For example, the code below uses the <b>wj-format</b> filter to format
     * a number as a currency value and a date as a short date using the
     * current Wijmo culture:
     *
     * <pre>&lt;p&gt;value: {&#8203;{ theAmount | wj-format('c') }}&lt;/p&gt;
     * &lt;p&gt;date: {&#8203;{ theDate | wj-format('d') }}&lt;/p&gt;</pre>
     */
    var WjFormat: any;
    /**
     * Vue directive to define tootips for elements.
     * TBD: description goes here...
     **/
    var WjTooltip: any;
    function registerCore(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.gauge.LinearGauge} control.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.gauge.LinearGauge} control using Vue markup:
     *
     * <pre>&lt;wj-linear-gauge
     *     :min="0" :max="1000" :step="50" :is-read-only="false"
     *     format="c0" :thumb-size="20"
     *     :show-ranges="false"
     *     :value="sales"
     *     :value-changed="salesChanged"&gt;
     *     &lt;wj-range wj-property="face" :thickness="0.5"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range wj-property="pointer" :thickness="0.5"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range :min="0" :max="333" color="red"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range :min="333" :max="666" color="gold"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range :min="666" :max="1000" color="green"&gt;
     *     &lt;/wj-range&gt;
     * &lt;/wj-linear-gauge&gt;</pre>
     *
     * The code <b>min</b>, <b>max</b>, <b>step</b>, and <b>isReadOnly</b> properties
     * to define the range of the gauge and to allow users to edit its value.
     * Next, it binds the gauge's <b>value</b> property to a <b>sales</b> variable
     * in the controller.
     *
     * Then it sets the <b>format</b>, <b>thumbSize</b>, and <b>showRanges</b>
     * properties to define the appearance of the gauge. Finally, the markup sets
     * the thickness of the <b>face</b> and <b>pointer</b> ranges, and extra ranges
     * that will control the color of the <b>value</b> range depending on the gauge's
     * current value.
     */
    var WjLinearGauge: any;
    /**
     * Vue component that encapsulates the {@link wijmo.gauge.BulletGraph} control.
     */
    var WjBulletGraph: any;
    /**
     * Vue component that encapsulates the {@link wijmo.gauge.RadialGauge} control.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.gauge.RadialGauge} control using Vue markup:
     *
     * <pre>&lt;wj-radial-gauge
     *     :min="0" :max="1000" :step="50" :is-read-only="false"
     *     format="c0" :thumb-size="12" :show-text="Value"
     *     :show-ranges="false"
     *     :value="sales"
     *     :value-changed="salesChanged"&gt;
     *     &lt;wj-range wj-property="face" :thickness="0.5"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range wj-property="pointer" :thickness="0.5"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range :min="0" :max="333" color="red"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range :min="333" :max="666" color="gold"&gt;
     *     &lt;/wj-range&gt;
     *     &lt;wj-range :min="666" :max="1000" color="green"&gt;
     *     &lt;/wj-range&gt;
     * &lt;/wj-radial-gauge&gt;</pre>
     *
     * The code <b>min</b>, <b>max</b>, <b>step</b>, and <b>isReadOnly</b> properties
     * to define the range of the gauge and to allow users to edit its value.
     * Next, it binds the gauge's <b>value</b> property to a <b>sales</b> variable
     * in the controller.
     *
     * Then it sets the <b>format</b>, <b>thumbSize</b>, and <b>showRanges</b>
     * properties to define the appearance of the gauge. Finally, the markup sets
     * the thickness of the <b>face</b> and <b>pointer</b> ranges, and extra ranges
     * that will control the color of the <b>value</b> range depending on the gauge's
     * current value.
     */
    var WjRadialGauge: any;
    /**
     * Vue component that represents a {@link wijmo.gauge.Range} in one of the following components:
     * {@link wijmo.vue2.gauge.WjLinearGauge}
     * , {@link wijmo.vue2.gauge.WjBulletGraph}
     *  or {@link wijmo.vue2.gauge.WjRadialGauge}.
     */
    var WjRange: any;
    function registerGauge(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that represents a {@link wijmo.grid.detail.FlexGridDetailProvider} in a {@link wijmo.vue2.grid.WjFlexGrid}.
     */
    var WjFlexGridDetail: any;
    function registerGridDetail(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that represents a {@link wijmo.grid.filter.FlexGridFilter} in a {@link wijmo.vue2.grid.WjFlexGrid}.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.grid.filter.FlexGridFilter} control with a filter using Vue markup:
     *
     * <pre>&lt;wj-flex-grid
     *   :items-source="data"&gt;
     *   &lt;wj-flex-grid-filter&gt;&lt;/wj-flex-grid-filter&gt;
     * &lt;/wj-flex-grid&gt;</pre>
     */
    var WjFlexGridFilter: any;
    function registerGridFilter(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.grid.grouppanel.GroupPanel} control.
     *
     * The example below shows how to instantiate and connect a
     * {@link wijmo.grid.grouppanel.GroupPanel} and a {@link wijmo.grid.FlexGrid}
     * in Vue:
     *
     * <pre>&lt;wj-group-panel
     *   id="thePanel"
     *   placeholder="Drag columns here to create Groups"&gt;
     * &lt;/wj-group-panel&gt;
     * &lt;wj-flex-grid
     *   id="theGrid"
     *   :items-source="data"&gt;
     * &lt;/wj-flex-grid&gt;</pre>
     *
     * <pre>var app = new Vue({
     *   el: '#app',
     *   // connect group panel and grid
     *   mounted: function () {
     *     var panel = wijmo.Control.getControl(document.getElementById('thePanel'));
     *     var grid = wijmo.Control.getControl(document.getElementById('theGrid'));
     *     panel.grid = grid;
     *   }
     * });</pre>
     */
    var WjGroupPanel: any;
    function registerGridGrouppanel(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.grid.search.FlexGridSearch} control.
     */
    var WjFlexGridSearch: any;
    function registerGridSearch(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.grid.multirow.MultiRow} control.
     */
    var WjMultiRow: any;
    function registerGridMultirow(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.grid.sheet.FlexSheet} control.
     */
    var WjFlexSheet: any;
    /**
     * Vue component that represents a {@link wijmo.grid.sheet.Sheet} in a {@link wijmo.vue2.grid.sheet.WjFlexSheet}.
     */
    var WjSheet: any;
    function registerGridSheet(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.grid.transposed.TransposedGrid} control.
     */
    var WjTransposedGrid: any;
    /**
     * Vue component that represents a {@link wijmo.grid.transposed.TransposedGridRow} in a {@link wijmo.vue2.grid.transposed.WjTransposedGrid}.
     */
    var WjTransposedGridRow: any;
    function registerGridTransposed(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.grid.transposedmultirow.TransposedMultiRow} control.
     */
    var WjTransposedMultiRow: any;
    function registerGridTransposedMultirow(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Represents a cell template types enumeration.
     */
    export import CellTemplateType = GridCellTemplateType;
    /**
     * Vue component that encapsulates the {@link wijmo.grid.FlexGrid} control.
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.grid.FlexGrid} control using Vue markup:
     *
     * <pre>&lt;wj-flex-grid
     *   :items-source="data"&gt;
     *   &lt;wj-flex-grid-column binding="name" header="Name"&gt;
     *   &lt;/wj-flex-grid-column&gt;
     *   &lt;wj-flex-grid-column binding="sales" header="Sales" format="c0"&gt;
     *   &lt;/wj-flex-grid-column&gt;
     *   &lt;wj-flex-grid-column binding="expenses" header="Expenses" format="c0"&gt;
     *   &lt;/wj-flex-grid-column&gt;
     *   &lt;wj-flex-grid-column binding="active" header="Active"&gt;
     *   &lt;/wj-flex-grid-column&gt;
     *   &lt;wj-flex-grid-column binding="date" header="Date"&gt;
     *   &lt;/wj-flex-grid-column&gt;
     * &lt;/wj-flex-grid&gt;</pre>
     *
     * The code sets the <b>itemsSource</b> property to a collection that contains the grid
     * data, then specifies the columns to display using <b>wj-flex-grid-column</b>
     * components.
     */
    var WjFlexGrid: any;
    /**
     * Vue component that represents a {@link wijmo.grid.Column} in a {@link wijmo.vue2.grid.WjFlexGrid}.
     */
    var WjFlexGridColumn: any;
    /**
    * Vue component for the {@link FlexGrid} cell templates.
    *
    * The <b>wj-flex-grid-cell-template</b> component defines a template for a certain
    * cell type in {@link FlexGrid}. The template element must contain a <b>cellType</b> attribute that
    * specifies the {@link wijmo.vue2.grid.CellTemplateType}. Depending on the template's cell type,
    * the <b>wj-flex-grid-cell-template</b> element must be a child
    * of either {@link wijmo.vue2.grid.WjFlexGrid}
    * or {@link wijmo.vue2.grid.WjFlexGridColumn} components.
    *
    * Column-specific cell templates must be contained in <b>wj-flex-grid-column</b>
    * components, and cells that are not column-specific (like row header or top left cells)
    * must be contained in the <b>wj-flex-grid</b> component.
    *
    * The <b>wj-flex-grid-cell-template</b> element
    * may contain an arbitrary HTML fragment with Vue interpolation expressions and
    * other components and directives.
    *
    * Bindings in HTML fragment can use scoped slot properties that store cell specific data.
    * The properties are <b>col</b>, <b>row</b>, and <b>item</b>, which refer to the {@link Column},
    * {@link Row}, and <b>Row.dataItem</b> objects pertaining to the cell.
    *
    * For cell types like <b>Group</b> and <b>CellEdit</b>, an additional <b>value</b>
    * property containing an unformatted cell value is provided.
    *
    * To reference slot properties, you can use either a new v-slot directive right on the
    * <b>wj-flex-grid-cell-template</b> element (it's available in Vue 2.6.0 or higher),
    * or an old slot-scope directive on the <b>&lt;template&gt;</b> element nested in
    * wj-flex-grid-cell-template.
    *
    * For example, here is a
    * {@link FlexGrid} control with templates for row header cells and, regular
    * and column header cells of the Country column:
    *
    * ```html
    * <!-- component.html -->
    * <wj-flex-grid :itemsSource="data">
    *   <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">
    *     {{cell.row.index}}
    *   </wj-flex-grid-cell-template>
    *   <wj-flex-grid-cell-template cellType="RowHeaderEdit">
    *     ...
    *   </wj-flex-grid-cell-template>
    *
    *   <wj-flex-grid-column header="Country" binding="country">
    *     <wj-flex-grid-cell-template cellType="ColumnHeader" v-slot="cell">
    *       <img src="resources/globe.png" />
    *         {{cell.col.header}}
    *     </wj-flex-grid-cell-template>
    *     <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
    *       <img :src="'resources/' + cell.item.country + '.png'" />
    *       {{cell.item.country}}
    *     </wj-flex-grid-cell-template>
    *   </wj-flex-grid-column>
    *   <wj-flex-grid-column header="Sales" binding="sales"></wj-flex-grid-column>
    * </wj-flex-grid>
    * ```
    *
    * The <b>wj-flex-grid-cell-template</b> directive supports the following attributes:
    *
    * <dl class="dl-horizontal">
    *   <dt>cellType</dt>
    *   <dd>
    *     The <b>CellTemplateType</b> value defining the type of cell to which the template is applied.
    *   </dd>
    *   <dt>autoSizeRows</dt>
    *   <dd>
    *     Indicates whether the cell template will increase grid's default row height
    *     to accomodate cells content. Defaults to true.
    *   </dd>
    *   <dt>cellOverflow</dt>
    *   <dd>
    *     Defines the <b>style.overflow</b> property value for cells.
    *   </dd>
    *   <dt>forceFullEdit</dt>
    *   <dd>
    *     For cell edit templates, indicates whether cell editing forcibly starts in full edit mode,
    *     regardless of how the editing was initiated. In full edit mode pressing cursor keys don't finish editing.
    *     Defaults to true.
    *   </dd>
    * </dl>
    *
    * The <b>cellType</b> attribute takes any of the following enumerated values:
    *
    * <b>Cell</b>
    *
    * Defines a regular (data) cell template. Must be a child of the {@link wijmo.vue2.grid.WjFlexGridColumn} component.
    * For example, this cell template shows flags in the cells of Country column:
    *
    * ```html
    * <wj-flex-grid-column header="Country" binding="country">
    *   <wj-flex-grid-cell-template cellType="Cell" v-slot="cell">
    *     <img :src="'resources/' + cell.item.country + '.png'" />
    *     {{cell.item.country}}
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    *
    * If <b>Group</b> template is not provided for a hierarchical {@link FlexGrid} (that is, one with the <b>childItemsPath</b> property
    * specified), non-header cells in group rows of
    * this {@link Column} also use this template.
    *
    * <b>CellEdit</b>
    *
    * Defines a template for a cell in edit mode. Must be a child of the {@link wijmo.vue2.grid.WjFlexGridColumn} component.
    * This cell type has an additional <b>value</b> scoped slot property available for binding. It contains the
    * original cell value before editing, and the updated value after editing.
    *
    * For example, here is a template that uses the Wijmo {@link InputNumber} control as an editor
    * for the "Sales" column:
    * ```html
    * <wj-flex-grid-column header="Sales" binding="sales">
    *   <wj-flex-grid-cell-template cellType="CellEdit">
    *     <wj-input-number v-model="cell.value" :step="1"></wj-input-number>
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    *
    * Note that two-way binding can also be specified using the binding's <b>sync</b> modifier:
    * ```html
    * <wj-flex-grid-column header="Sales" binding="sales">
    *   <wj-flex-grid-cell-template cellType="CellEdit">
    *     <wj-input-number value.sync="cell.value" :step="1"></wj-input-number>
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    *
    * <b>ColumnHeader</b>
    *
    * Defines a template for a column header cell. Must be a child of the {@link wijmo.vue2.grid.WjFlexGridColumn} component.
    * For example, this template adds an image to the header of the "Country" column:
    *
    * ```html
    * <wj-flex-grid-column header="Country" binding="country">
    *   <wj-flex-grid-cell-template cellType="ColumnHeader" v-slot="cell">
    *     <img src="resources/globe.png" />
    *     {{cell.col.header}}
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    *
    * <b>RowHeader</b>
    *
    * Defines a template for a row header cell. Must be a child of the {@link wijmo.vue2.grid.WjFlexGrid} component.
    * For example, this template shows row indices in the row headers:
    *
    * ```html
    * <wj-flex-grid :itemsSource="data">
    *   <wj-flex-grid-cell-template cellType="RowHeader" v-slot="cell">
    *     {{cell.row.index + 1}}
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid>
    * ```
    *
    * Note that this template is applied to a row header cell, even if it is in a row that is
    * in edit mode. In order to provide an edit-mode version of a row header cell with alternate
    * content, define the <b>RowHeaderEdit</b> template.
    *
    * <b>RowHeaderEdit</b>
    *
    * Defines a template for a row header cell in edit mode. Must be a child of the
    * {@link wijmo.vue2.grid.WjFlexGrid} component. For example, this template shows dots in the header
    * of rows being edited:
    *
    * ```html
    * <wj-flex-grid :itemsSource="data">
    *   <wj-flex-grid-cell-template cellType="RowHeaderEdit">
    *     ...
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid>
    * ```
    *
    * Use the following <b>RowHeaderEdit</b> template to add the standard edit-mode indicator to cells where the <b>RowHeader</b> template
    * applies:
    *
    * ```html
    * <wj-flex-grid :itemsSource="data">
    *   <wj-flex-grid-cell-template cellType="RowHeaderEdit">
    *     &#x270e;&#xfe0e;
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid>
    * ```
    *
    * <b>TopLeft</b>
    *
    * Defines a template for the top left cell. Must be a child of the {@link wijmo.vue2.grid.WjFlexGrid} component.
    * For example, this template shows a down/right glyph in the top-left cell of the grid:
    *
    * ```html
    * <wj-flex-grid :itemsSource="data">
    *   <wj-flex-grid-cell-template cellType="TopLeft">
    *     <span class="wj-glyph-down-right"></span>
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid>
    * ```
    *
    * <b>GroupHeader</b>
    *
    * Defines a template for a group header cell in a {@link GroupRow}. Must be a child of the {@link wijmo.vue2.grid.WjFlexGridColumn} component.
    *
    * The <b>row</b> scoped slot property contains an instance of the <b>GroupRow</b> class. If the grouping comes
    * from {@link CollectionView}, the <b>item</b> scoped slot property references the {@link CollectionViewGroup} object.
    *
    * For example, this template uses a checkbox element as an expand/collapse toggle:
    *
    * ```html
    * <wj-flex-grid-column header="Country" binding="country">
    *   <wj-flex-grid-cell-template cellType="GroupHeader" v-slot="cell">
    *     <input type="checkbox" v-model="cell.row.isCollapsed"/>
    *     {{cell.item.name}} ({{cell.item.items.length}} items)
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    *
    * <b>Group</b>
    *
    * Defines a template for a regular cell (not a group header) in a {@link GroupRow}. Must be a child of the
    * {@link wijmo.vue2.grid.WjFlexGridColumn} component. This cell type has an additional <b>value</b> scoped
    * slot property available for
    * binding. In cases where columns have the <b>aggregate</b> property specified, it contains the unformatted
    * aggregate value.
    *
    * For example, this template shows aggregate's value and kind for group row cells in the "Sales"
    * column:
    *
    * ```html
    * <wj-flex-grid-column header="Sales" binding="sales" aggregate="Avg">
    *   <wj-flex-grid-cell-template cellType="Group" v-slot="cell">
    *     Average: {{formatNumber(cell.value, 'N0')}}
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    *
    * <b>ColumnFooter</b>
    *
    * Defines a template for a regular cell in a <b>columnFooters</b> panel. Must be a child of the
    * {@link wijmo.vue2.grid.WjFlexGridColumn} component. This cell type has an additional <b>value</b>
    * scoped slot property available for binding that contains a cell value.
    *
    * For example, this template shows aggregate's value and kind for a footer cell in the "Sales"
    * column:
    *
    * ```html
    * <wj-flex-grid-column header="Sales" binding="sales" aggregate="Avg">
    *   <wj-flex-grid-cell-template cellType="ColumnFooter" v-slot="cell">
    *     Average: {{formatNumber(cell.value, 'N0')}}
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    *
    * <b>BottomLeft</b>
    *
    * Defines a template for the bottom left cells (at the intersection of the row header and column footer cells).
    * Must be a child of the {@link wijmo.vue2.grid.WjFlexGrid} component.
    * For example, this template shows a sigma glyph in the bottom-left cell of the grid:
    *
    * ```html
    * <wj-flex-grid :itemsSource="data">
    *   <wj-flex-grid-cell-template cellType="BottomLeft">
    *     &#931;
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid>
    * ```
    *
    * <b>NewCellTemplate</b>
    *
    * Defines a cell in a new row template. Must be a child of the {@link wijmo.vue2.grid.WjFlexGridColumn} component.
    * Note that the <b>cell.item</b> property is undefined for this type of a cell.
    * For example, this cell template shows a placeholder in the Date column's cell in the "new row" item:
    *
    * ```html
    * <wj-flex-grid-column header="'Date'" binding="'date'">
    *   <wj-flex-grid-cell-template cellType="NewCellTemplate">
    *     Enter a date here
    *   </wj-flex-grid-cell-template>
    * </wj-flex-grid-column>
    * ```
    */
    var WjFlexGridCellTemplate: any;
    function registerGrid(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.input.ListBox} control.
     */
    var WjListBox: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.MultiSelectListBox} control.
     */
    var WjMultiSelectListBox: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.ComboBox} control.
     */
    var WjComboBox: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.AutoComplete} control.
     */
    var WjAutoComplete: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.Calendar} control.
     */
    var WjCalendar: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.ColorPicker} control.
     */
    var WjColorPicker: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.InputMask} control.
     */
    var WjInputMask: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.InputColor} control.
     */
    var WjInputColor: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.MultiSelect} control.
     */
    var WjMultiSelect: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.MultiAutoComplete} control.
     */
    var WjMultiAutoComplete: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.InputNumber} control.
     */
    var WjInputNumber: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.InputDate} control.
     */
    var WjInputDate: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.InputTime} control.
     */
    var WjInputTime: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.InputDateTime} control.
     */
    var WjInputDateTime: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.Menu} control.
     */
    var WjMenu: any;
    /**
     * Vue component for {@link wijmo.vue2.input.WjMenu} items.
     */
    var WjMenuItem: any;
    /**
     * Vue component for {@link wijmo.vue2.input.WjMenu} item separators.
     */
    var WjMenuSeparator: any;
    /**
     * Vue component to define item templates for item
     * controls like {@link ListBox}, {@link ComboBox}, {@link MultiSelect}
     * and  {@link Menu}.
     */
    var WjItemTemplate: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.Popup} control.
     */
    var WjPopup: any;
    /**
     * Vue directive to define context menus for elements.
     * TBD: description goes here...
     **/
    var WjContextMenu: any;
    /**
     * Vue component that encapsulates the {@link wijmo.input.CollectionViewNavigator} control.
     */
    var WjCollectionViewNavigator: any;
    function registerInput(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.olap.PivotGrid} control.
     */
    var WjPivotGrid: any;
    /**
     * Vue component that encapsulates the {@link wijmo.olap.PivotChart} control.
     */
    var WjPivotChart: any;
    /**
     * Vue component that encapsulates the {@link wijmo.olap.PivotPanel} control.
     */
    var WjPivotPanel: any;
    /**
     * Vue component that encapsulates the {@link wijmo.olap.Slicer} control.
     */
    var WjSlicer: any;
    function registerOlap(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.viewer.ReportViewer} control.
     */
    var WjReportViewer: any;
    /**
     * Vue component that encapsulates the {@link wijmo.viewer.PdfViewer} control.
     */
    var WjPdfViewer: any;
    function registerViewer(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.nav.TreeView} control.
     */
    var WjTreeView: any;
    /**
     * Vue component that encapsulates the {@link wijmo.nav.TabPanel} control.
     */
    var WjTabPanel: any;
    /**
     * Vue component that represents a {@link wijmo.nav.Tab} in a {@link wijmo.vue2.nav.WjTabPanel}.
     */
    var WjTab: any;
    /**
     * Vue component that encapsulates the {@link wijmo.nav.Accordion} control.
     */
    var WjAccordion: any;
    /**
     * Vue component that represents a {@link wijmo.nav.AccordionPane} in a {@link wijmo.vue2.nav.WjAccordion}.
     */
    var WjAccordionPane: any;
    function registerNav(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.Codabar} control.
     */
    var WjBarcodeCodabar: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.Ean8} control.
     */
    var WjBarcodeEan8: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.Ean13} control.
     */
    var WjBarcodeEan13: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.Code39} control.
     */
    var WjBarcodeCode39: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.Code128} control.
     */
    var WjBarcodeCode128: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.Gs1_128} control.
     */
    var WjBarcodeGs1_128: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.UpcA} control.
     */
    var WjBarcodeUpcA: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.UpcE0} control.
     */
    var WjBarcodeUpcE0: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.UpcE1} control.
     */
    var WjBarcodeUpcE1: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.common.QrCode} control.
     */
    var WjBarcodeQrCode: any;
    function registerBarcodeCommon(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarOmnidirectional} control.
     */
    var WjBarcodeGs1DataBarOmnidirectional: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarTruncated} control.
     */
    var WjBarcodeGs1DataBarTruncated: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarStacked} control.
     */
    var WjBarcodeGs1DataBarStacked: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarStackedOmnidirectional} control.
     */
    var WjBarcodeGs1DataBarStackedOmnidirectional: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarLimited} control.
     */
    var WjBarcodeGs1DataBarLimited: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarExpanded} control.
     */
    var WjBarcodeGs1DataBarExpanded: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarExpandedStacked} control.
     */
    var WjBarcodeGs1DataBarExpandedStacked: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.Pdf417} control.
     */
    var WjBarcodePdf417: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.composite.MicroPdf417} control.
     */
    var WjBarcodeMicroPdf417: any;
    function registerBarcodeComposite(app: any): void;
}
declare module wijmo.vue2 {
}
declare module wijmo.vue2 {
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.specialized.DataMatrixEcc000} control.
     */
    var WjBarcodeDataMatrixEcc000: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.specialized.DataMatrixEcc200} control.
     */
    var WjBarcodeDataMatrixEcc200: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.specialized.Code49} control.
     */
    var WjBarcodeCode49: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.specialized.Code93} control.
     */
    var WjBarcodeCode93: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.specialized.Itf14} control.
     */
    var WjBarcodeItf14: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.specialized.Interleaved2of5} control.
     */
    var WjBarcodeInterleaved2of5: any;
    /**
     * Vue component that encapsulates the {@link wijmo.barcode.specialized.JapanesePostal} control.
     */
    var WjBarcodeJapanesePostal: any;
    function registerBarcodeSpecialized(app: any): void;
}
declare module wijmo.vue2 {
}
