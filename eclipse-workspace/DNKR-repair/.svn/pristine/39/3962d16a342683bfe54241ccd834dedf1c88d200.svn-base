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

declare module wijmo.react {
    function softInput(): typeof wijmo.input;
    function softGridDetail(): typeof wijmo.grid.detail;
}
declare module wijmo.react {
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
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * Base class for all Wijmo components for React.
     */
    class ComponentBase extends React.Component<any, any> {
        static readonly _propsParent: string;
        static readonly _typeSiblingIdProp: string;
        static _siblingDirId: number;
        private _objPropHash;
        private _isMounted;
        private _mountedCBs;
        private _siblingInsertedEH;
        controlType: any;
        props: any;
        control: any;
        parent: ComponentBase;
        protected _parentProp: string;
        protected _parentInCtor: boolean;
        protected _siblingId: string;
        protected _hostRef: React.RefObject<HTMLElement>;
        constructor(props: any, controlType: any, meta?: any);
        render(): any;
        componentDidMount(): any;
        componentWillUnmount(): void;
        shouldComponentUpdate(nextProps: any): boolean;
        componentDidUpdate(prevProps: any): void;
        _mountedCB(cb: () => void): void;
        protected _renderImpl(): any;
        readonly _beforeRender: Event<any, EventArgs>;
        protected _onBeforeRender(e?: wijmo.EventArgs): void;
        readonly _afterRender: Event<any, EventArgs>;
        protected _onAfterRender(e?: wijmo.EventArgs): void;
        readonly _beforeWillUnmount: Event<any, EventArgs>;
        protected _onBeforeWillUnmount(e?: wijmo.EventArgs): void;
        readonly _afterWillUnmount: Event<any, EventArgs>;
        protected _onAfterWillUnmount(e?: wijmo.EventArgs): void;
        readonly _beforeDidUpdate: Event<any, EventArgs>;
        protected _onBeforeDidUpdate(e?: wijmo.EventArgs): void;
        readonly _afterDidUpdate: Event<any, EventArgs>;
        protected _onAfterDidUpdate(e?: wijmo.EventArgs): void;
        protected _createControl(): any;
        private _prepareControl;
        protected _initParent(): void;
        private _setParent;
        private _isChild;
        private _isParentInCtor;
        private _getParentProp;
        private _getSiblingIndex;
        private _siblingInserted;
        private _copy;
        private _setHostAttribute;
        private _sameValue;
        private _isEvent;
        protected _getElement(): HTMLElement;
        private _ignoreProp;
        private static _copyAttrs;
        static isInStrictMode(component: any): boolean;
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.chart.analytics.TrendLine} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartTrendLine extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.analytics.MovingAverage} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartMovingAverage extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.analytics.YFunctionSeries} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartYFunctionSeries extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.analytics.ParametricFunctionSeries} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartParametricFunctionSeries extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.analytics.Waterfall} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartWaterfall extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.analytics.BoxWhisker} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartBoxWhisker extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.analytics.ErrorBar} in a {@link wijmo.react.chart.FlexChart}.
     */
    class FlexChartErrorBar extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.analytics.BreakEven} in a {@link wijmo.react.chart.FlexChart}.
     */
    class FlexChartBreakEven extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.chart.animation.ChartAnimation} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     * , {@link wijmo.react.chart.FlexPie}
     * , {@link wijmo.react.chart.finance.FinancialChart}
     *  or {@link wijmo.react.chart.radar.FlexRadar}.
     */
    class FlexChartAnimation extends ComponentBase {
        _parentInCtor: boolean;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.chart.annotation.AnnotationLayer} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartAnnotationLayer extends ComponentBase {
        _parentInCtor: boolean;
        constructor(props: any);
    }
    /**
 * React component that represents objects inherited from the
 * {@link wijmo.chart.annotation.AnnotationBase} class.
     */
    class FlexChartAnnotation extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
        protected _createControl(): any;
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.Fibonacci} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartFibonacci extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.FibonacciArcs} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartFibonacciArcs extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.FibonacciFans} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartFibonacciFans extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.FibonacciTimeZones} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartFibonacciTimeZones extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.ATR} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartAtr extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.CCI} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartCci extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.RSI} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartRsi extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.WilliamsR} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartWilliamsR extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.Macd} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartMacd extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.MacdHistogram} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartMacdHistogram extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.Stochastic} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartStochastic extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.BollingerBands} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartBollingerBands extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.analytics.Envelopes} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartEnvelopes extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.chart.finance.FinancialChart} control.
     */
    class FinancialChart extends ComponentBase {
        constructor(props: any);
        componentDidMount(): any;
        componentDidUpdate(prevProps: any): void;
        private _setExtra;
    }
    /**
     * React component that represents a {@link wijmo.chart.finance.FinancialSeries} in a {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FinancialChartSeries extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.chart.hierarchical.Sunburst} control.
     */
    class Sunburst extends ComponentBase {
        constructor(props: any);
        componentDidMount(): any;
        componentDidUpdate(prevProps: any): void;
        private _setExtra;
    }
    /**
     * React component that encapsulates the {@link wijmo.chart.hierarchical.TreeMap} control.
     */
    class TreeMap extends ComponentBase {
        constructor(props: any);
        componentDidMount(): any;
        componentDidUpdate(prevProps: any): void;
        private _setExtra;
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.chart.interaction.RangeSelector} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartRangeSelector extends ComponentBase {
        _parentInCtor: boolean;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.interaction.ChartGestures} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartGestures extends ComponentBase {
        _parentInCtor: boolean;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.chart.radar.FlexRadar} control.
     */
    class FlexRadar extends ComponentBase {
        constructor(props: any);
        componentDidMount(): any;
        componentDidUpdate(prevProps: any): void;
        private _setExtra;
    }
    /**
     * React component that represents a {@link wijmo.chart.radar.FlexRadarAxis} in one of the following components:
     * {@link wijmo.react.chart.radar.FlexRadar}
     *  or {@link wijmo.react.chart.radar.FlexRadarSeries}.
     */
    class FlexRadarAxis extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.radar.FlexRadarSeries} in a {@link wijmo.react.chart.radar.FlexRadar}.
     */
    class FlexRadarSeries extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.chart.FlexChart} control.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.chart.FlexChart} control in JSX:
     *
     * <pre>&lt;Wj.FlexChart
     *   itemsSource={ this.state.data }
     *   bindingX="name"
     *   header={ this.state.header }
     *   footer={ this.state.footer }
     *   axisX={&#8203;{ title: this.state.titleX }}
     *   axisY={&#8203;{ title: this.state.titleY }}
     *   legend={&#8203;{ position: this.state.legendPosition }}
     *   series={[
     *       { name: 'Sales', binding: 'sales' },
     *       { name: 'Expenses', binding: 'expenses' },
     *       { name: 'Downloads', binding: 'downloads', chartType: 'LineSymbols' }
     *   ]} /&gt;</pre>
     *

     * The code sets the <b>itemsSource</b> property to a collection that contains
     * the data to chart and the <b>bindingX</b> property to specify the name of the
     * data property to use for the chart's X values.
     *
     * It sets the <b>header</b> and <b>footer</b> properties to specify the
     * chart titles, and customizes the chart's axes and legend.
     *
     * Finally, it sets the <b>series</b> property to an array that specifies the
     * data items that the chart should display.
     */
    class FlexChart extends ComponentBase {
        constructor(props: any);
        componentDidMount(): any;
        componentDidUpdate(prevProps: any): void;
        private _setExtra;
    }
    /**
     * React component that encapsulates the {@link wijmo.chart.FlexPie} control.
     */
    class FlexPie extends ComponentBase {
        constructor(props: any);
        componentDidMount(): any;
        componentDidUpdate(prevProps: any): void;
        private _setExtra;
    }
    /**
     * React component that represents a {@link wijmo.chart.Axis} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     * , {@link wijmo.react.chart.FlexChartSeries}
     * , {@link wijmo.react.chart.finance.FinancialChart}
     *  or {@link wijmo.react.chart.finance.FinancialChartSeries}.
     */
    class FlexChartAxis extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.Legend} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     * , {@link wijmo.react.chart.FlexPie}
     * , {@link wijmo.react.chart.finance.FinancialChart}
     * , {@link wijmo.react.chart.radar.FlexRadar}
     *  or {@link wijmo.react.chart.hierarchical.Sunburst}.
     */
    class FlexChartLegend extends ComponentBase {
        _parentProp: string;
        _parentInCtor: boolean;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.DataLabel} in a {@link wijmo.react.chart.FlexChart}.
     */
    class FlexChartDataLabel extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.PieDataLabel} in a {@link wijmo.react.chart.FlexPie}.
     */
    class FlexPieDataLabel extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.Series} in a {@link wijmo.react.chart.FlexChart}.
     */
    class FlexChartSeries extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.LineMarker} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartLineMarker extends ComponentBase {
        _parentInCtor: boolean;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.DataPoint} in a {@link wijmo.react.chart.annotation.FlexChartAnnotation}.
     */
    class FlexChartDataPoint extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.chart.PlotArea} in one of the following components:
     * {@link wijmo.react.chart.FlexChart}
     *  or {@link wijmo.react.chart.finance.FinancialChart}.
     */
    class FlexChartPlotArea extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.gauge.LinearGauge} control.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.gauge.LinearGauge} control in JSX:
     *
     * <pre>&lt;Wj.LinearGauge
     *   min={ 0 } max={ 1000 } step={ 50 } isReadOnly={ false }
     *   value={ this.state.view.currentItem.sales }
     *   valueChanged={ this.salesChanged }
     *   format="c0" thumbSize={ 20 } showRanges={ false }
     *   face={&#8203;{ thickness:0.5 }}
     *   pointer={&#8203;{ thickness:0.5 }}
     *   ranges={[
     *       { min: 0, max: 333, color: 'red' },
     *       { min: 333, max: 666, color: 'gold' },
     *       { min: 666, max: 1000, color: 'green' }
     *   ]} /&gt;</pre>
     *
     * The code <b>min</b>, <b>max</b>, <b>step</b>, and <b>isReadOnly</b> properties
     * to define the range of the gauge and to allow users to edit its value.
     * Next, it sets the <b>value</b> and <b>valueChanged</b> properties to create
     * a two-way binding for the gauge's value.
     *
     * Then it sets the <b>format</b>, <b>thumbSize</b>, and <b>showRanges</b>
     * properties to define the appearance of the gauge. Finally, the markup sets
     * the thickness of the <b>face</b> and <b>pointer</b> ranges, and extra ranges
     * that will control the color of the <b>value</b> range depending on the gauge's
     * current value.
     */
    class LinearGauge extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.gauge.BulletGraph} control.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.gauge.BulletGraph} control in JSX:
     *
     * <pre>&lt;Wj.BulletGraph
     *   min={ 0 } max={ 1000 } step={ 50 } isReadOnly={ false }
     *   value={ this.state.view.currentItem.sales }
     *   valueChanged={ this.salesChanged }
     *   format="c0" thumbSize={ 20 } showRanges={ false }
     *   face={&#8203;{ thickness:0.5 }}
     *   pointer={&#8203;{ thickness:0.5 }}
     *   ranges={[
     *       { min: 0, max: 333, color: 'red' },
     *       { min: 333, max: 666, color: 'gold' },
     *       { min: 666, max: 1000, color: 'green' }
     *   ]} /&gt;</pre>
     *
     * The code <b>min</b>, <b>max</b>, <b>step</b>, and <b>isReadOnly</b> properties
     * to define the range of the gauge and to allow users to edit its value.
     * Next, it sets the <b>value</b> and <b>valueChanged</b> properties to create
     * a two-way binding for the gauge's value.
     *
     * Then it sets the <b>format</b>, <b>thumbSize</b>, and <b>showRanges</b>
     * properties to define the appearance of the gauge. Finally, the markup sets
     * the thickness of the <b>face</b> and <b>pointer</b> ranges, and extra ranges
     * that will control the color of the <b>value</b> range depending on the gauge's
     * current value.
     */
    class BulletGraph extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.gauge.RadialGauge} control.
     *
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.gauge.RadialGauge} control in JSX:
     *
     * <pre>&lt;Wj.RadialGauge
     *   min={ 0 } max={ 1000 } step={ 50 } isReadOnly={ false }
     *   value={ this.state.view.currentItem.sales }
     *   valueChanged={ this.salesChanged }
     *   format="c0" thumbSize={ 20 } showRanges={ false }
     *   face={&#8203;{ thickness:0.5 }}
     *   pointer={&#8203;{ thickness:0.5 }}
     *   ranges={[
     *       { min: 0, max: 333, color: 'red' },
     *       { min: 333, max: 666, color: 'gold' },
     *       { min: 666, max: 1000, color: 'green' }
     *   ]} /&gt;</pre>
     *
     * The code <b>min</b>, <b>max</b>, <b>step</b>, and <b>isReadOnly</b> properties
     * to define the range of the gauge and to allow users to edit its value.
     * Next, it sets the <b>value</b> and <b>valueChanged</b> properties to create
     * a two-way binding for the gauge's value.
     *
     * Then it sets the <b>format</b>, <b>thumbSize</b>, and <b>showRanges</b>
     * properties to define the appearance of the gauge. Finally, the markup sets
     * the thickness of the <b>face</b> and <b>pointer</b> ranges, and extra ranges
     * that will control the color of the <b>value</b> range depending on the gauge's
     * current value.
     */
    class RadialGauge extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.gauge.Range} in one of the following components:
     * {@link wijmo.react.gauge.LinearGauge}
     * , {@link wijmo.react.gauge.BulletGraph}
     *  or {@link wijmo.react.gauge.RadialGauge}.
     */
    class Range extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.grid.detail.FlexGridDetailProvider} in a {@link wijmo.react.grid.FlexGrid}.
     */
    class FlexGridDetail extends ComponentBase {
        _parentInCtor: boolean;
        private _renderedCells;
        private _template;
        constructor(props: any);
        protected _onBeforeWillUnmount(e?: wijmo.EventArgs): void;
        protected _initParent(): void;
        componentDidUpdate(prevProps: any): void;
        private _setTemplateRelatedProps;
        private _getTemplateContext;
        private _unmountRenderedCells;
        private _getCellCreator;
        private _destroyCell;
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.grid.filter.FlexGridFilter} in a {@link wijmo.react.grid.FlexGrid}.
     */
    class FlexGridFilter extends ComponentBase {
        _parentInCtor: boolean;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.grid.grouppanel.GroupPanel} control.
     */
    class GroupPanel extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.grid.search.FlexGridSearch} control.
     */
    class FlexGridSearch extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.grid.multirow.MultiRow} control.
     */
    class MultiRow extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.grid.sheet.FlexSheet} control.
     */
    class FlexSheet extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.grid.sheet.Sheet} in a {@link wijmo.react.grid.sheet.FlexSheet}.
     */
    class Sheet extends ComponentBase {
        _parentProp: string;
        _parentInCtor: boolean;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.grid.transposed.TransposedGrid} control.
     */
    class TransposedGrid extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that represents a {@link wijmo.grid.transposed.TransposedGridRow} in a {@link wijmo.react.grid.transposed.TransposedGrid}.
     */
    class TransposedGridRow extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
        protected _initParent(): void;
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.grid.transposedmultirow.TransposedMultiRow} control.
     */
    class TransposedMultiRow extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that represents a {@link wijmo.grid.immutable.ImmutabilityProvider} in a {@link wijmo.react.grid.FlexGrid}.
     *
     * The {@link wijmo.react.grid.immutable.ImmutabilityProvider} component,
     * being added to a {@link wijmo.react.grid.FlexGrid} component,
     * allows the latter to perform data edits without mutating the underlying
     * data. Instead, this class provides a data change event, which can be used to dispatch
     * change actions to the global _Store_, such as a
     * <a href="https://redux.js.org/" target="_blank">Redux</a> _Store_.
     *
     * The controlled **FlexGrid** control should not specify its **itemsSource**. Instead, the
     * **itemsSource** property of this class instance should be assigned with the
     * immutable array from the _Store_, which grid will display and edit.
     *
     * When a user edits data via the grid,
     * the {@link wijmo.grid.immutable.ImmutabilityProvider.dataChanged} event is triggered,
     * bringing all the necessary information to you about the change (which item is affected,
     * if item was changed or added or deleted, and so on). This event should be used to dispatch
     * corresponding data change actions to the _Store_.
     *
     * Note that **FlexGrid** edits data on a row level basis, which means that you can change multiple
     * cell values in the same row, and only after you move focus out of the row, all the changes
     * to the row will be applied simultaneously. Or you can press the _Cancel_ key to cancel all
     * the changes in the row. The same is true for adding a row into the datagrid.
     *
     * Note also that some changes like pasting a text into the datagrid, or deleting rows,
     * can affect multiple rows. In this case **ImmutabilityProvider** will trigger
     * the {@link wijmo.grid.immutable.ImmutabilityProvider.dataChanged} event
     * multiple times, separately for each affected row. This simplifies data change processing
     * in the _Store_ reducers.
     *
     * This example demonstrates a fully editable **FlexGrid** component, with an associated
     * **ImmutabilityProvider** component bound to an array from the _Redux Store_. The dataChanged
     * event handler dispatches corresponding data change actions to the _Store_.
     * The example assumes that _Redux Store_ data and action creator functions are bound
     * to the presentation component as properties, using the _react-redux_ _connect_ method.
     * ```typescript
     * import { DataChangeEventArgs, DataChangeAction } from '@grapecity/wijmo.grid.immutable';
     * import { ImmutabilityProvider } from '@grapecity/wijmo.react.grid.immutable';
     * import { FlexGrid } from '@grapecity/wijmo.react.grid';
     *
     * export class GridView extends React.Component<any, any> {
     *   render() {
     *     return <FlexGrid allowAddNew allowDelete>
     *        <ImmutabilityProvider
     *           itemsSource={this.props.items}
     *           dataChanged={this.onGridDataChanged} />
     *     </FlexGrid>
     *   }
     *   onGridDataChanged(s: ImmutabilityProvider, e: DataChangeEventArgs) {
     *       switch (e.action) {
     *           case DataChangeAction.Add:
     *               this.props.addItemAction(e.newItem);
     *               break;
     *           case DataChangeAction.Remove:
     *               this.props.removeItemAction(e.newItem, e.itemIndex);
     *               break;
     *           case DataChangeAction.Change:
     *               this.props.changeItemAction(e.newItem, e.itemIndex);
     *               break;
     *       }
     *   }
     * }
     * ```
     */
    class ImmutabilityProvider extends ComponentBase {
        _parentInCtor: boolean;
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * Represents a cell template types enumeration.
     */
    export import CellTemplateType = GridCellTemplateType;
    /**
     * React component that encapsulates the {@link wijmo.grid.FlexGrid} control.
     * The example below shows how to instantiate and initialize a
     * {@link wijmo.grid.FlexGrid} control in JSX:
     *
     * <pre>&lt;Wj.FlexGrid
     *   autoGenerateColumns={ false }
     *   columns={[
     *     { binding: 'name', header: 'Name' },
     *     { binding: 'sales', header: 'Sales', format: 'c0' },
     *     { binding: 'expenses', header: 'Expenses', format: 'c0' },
     *     { binding: 'active', header: 'Active' },
     *     { binding: 'date', header: 'Date' }
     *   ]}
     *   itemsSource={ this.state.data } /&gt;</pre>
     *
     * The code sets the <b>autoGenerateColumns</b> property to false, then
     * sets the <b>columns</b> property, and finally sets the <b>itemsSource</b>
     * property. This order is important, it prevents the grid from automatically
     * generating the columns.
     */
    class FlexGrid extends ComponentBase {
        constructor(props: any);
        protected _createControl(): any;
    }
    /**
     * React component that represents a {@link wijmo.grid.Column} in a {@link wijmo.react.grid.FlexGrid}.
     */
    class FlexGridColumn extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
        protected _initParent(): void;
    }
    interface ICellTemplateContext {
        row: wijmo.grid.Row;
        col: wijmo.grid.Column;
        item: any;
        value: any;
        values: any;
    }
    type CellTemplateRender = (context: ICellTemplateContext) => any;
    /**
   * React component for the {@link FlexGrid} cell templates.
   *
   * The <b>FlexGridCellTemplate</b> component defines a template for a certain
   * cell type in {@link FlexGrid}. The template element must contain a <b>cellType</b> property that
   * specifies the {@link wijmo.react.grid.CellTemplateType}. Depending on the template's cell type,
   * the <b>FlexGridCellTemplate</b> element must be a child
   * of either {@link wijmo.react.grid.FlexGrid}
   * or {@link wijmo.react.grid.FlexGridColumn} components.
   *
   * Column-specific cell templates must be contained in <b>FlexGridColumn</b>
   * components, and cells that are not column-specific (like row header or top left cells)
   * must be contained in the <b>FlexGrid</b> component.
   *
   * The content of cells is defined using the <b>template</b> <i>render prop</i>, which receives
   * a render function that should return a virtual element tree representing the cell content.
   * The function has the <b>context</b> parameter where the data context of each certain cell is
   * passed. This is an object with the <b>col</b>, <b>row</b>, and <b>item</b> properties,
   * which refer to the {@link Column}, {@link Row}, and <b>Row.dataItem</b> objects pertaining to the cell.
   *
   * For cell types like <b>Group</b> and <b>CellEdit</b>, an additional <b>value</b>
   * context property containing an unformatted cell value is provided.
   *
   * For example, here is a
   * {@link FlexGrid} control with templates for row header cells and, regular
   * and column header cells of the Country column:
   *
   * ```html
   * <!-- component.html -->
   * <wjGrid.FlexGrid itemsSource={this.state.data}>
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="RowHeader"
   *       template={ (context) => context.row.index + 1 } />
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="RowHeaderEdit"
   *       template={ (context) => '...' } />
   *
   *   <wjGrid.FlexGridColumn header="Country" binding="country">
   *     <wjGrid.FlexGridCellTemplate
   *           cellType="ColumnHeader"
   *           template={ (context) => {
   *               return <React.Fragment>
   *                   <img src="resources/globe.png" />
   *                   {context.col.header}
   *               </React.Fragment>
   *               }
   *           }
   *      />
   *     <wjGrid.FlexGridCellTemplate
   *           cellType="Cell"
   *           template={ (context) => {
   *               return <React.Fragment>
   *                  <img src={`resources/${context.item.country}.png`} />
   *                  {context.item.country}
   *               </React.Fragment>
   *           } }
   *       />
   *   </wjGrid.FlexGridColumn>
   *   <wjGrid.FlexGridColumn header="Sales" binding="sales"></wjGrid.FlexGridColumn>
   * </wjGrid.FlexGrid>
   * ```
   *
   * The <b>FlexGridCellTemplate</b> directive supports the following properties:
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
   * Defines a regular (data) cell template. Must be a child of the {@link wijmo.react.grid.FlexGridColumn} component.
   * For example, this cell template shows flags in the cells of Country column:
   *
   * ```html
   * <wjGrid.FlexGridColumn header="Country" binding="country">
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="Cell"
   *       template={ (context) => {
   *           return <React.Fragment>
   *              <img src={`resources/${context.item.country}.png`} />
   *              {context.item.country}
   *           </React.Fragment>
   *       }
   *    }
   *   />
   * </wjGrid.FlexGridColumn>
   * ```
   *
   * If <b>Group</b> template is not provided for a hierarchical {@link FlexGrid} (that is, one with the <b>childItemsPath</b> property
   * specified), non-header cells in group rows of
   * this {@link Column} also use this template.
   *
   * <b>CellEdit</b>
   *
   * Defines a template for a cell in edit mode. Must be a child of the {@link wijmo.react.grid.FlexGridColumn} component.
   * This cell type has an additional <b>context.value</b> property. It contains the
   * original cell value before editing, and the updated value after editing.
   *
   * For example, here is a template that uses the Wijmo {@link InputNumber} control as an editor
   * for the "Sales" column:
   * ```html
   * <wjGrid.FlexGridColumn header="Sales" binding="sales">
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="CellEdit"
   *       template={ (context) => {
   *            return <wjInput.InputNumber
   *                step={1}
   *                value={context.value}
   *                valueChanged={(inpNum: wjcInput.InputNumber) =>
   *                    context.value = inpNum.value
   *                } />
   *            }
   *       }
   *   />
   * </wjGrid.FlexGridColumn>
   * ```
   *
   * <b>ColumnHeader</b>
   *
   * Defines a template for a column header cell. Must be a child of the {@link wijmo.react.grid.FlexGridColumn} component.
   * For example, this template adds an image to the header of the "Country" column:
   *
   * ```html
   * <wjGrid.FlexGridColumn header="Country" binding="country">
   *   <wjGrid.FlexGridCellTemplate
   *         cellType="ColumnHeader"
   *         template={ (context) => {
   *             return <React.Fragment>
   *                 <img src="resources/globe.png" />
   *                 {context.col.header}
   *             </React.Fragment>
   *             }
   *         }
   *   />
   * </wjGrid.FlexGridColumn>
   * ```
   *
   * <b>RowHeader</b>
   *
   * Defines a template for a row header cell. Must be a child of the {@link wijmo.react.grid.FlexGrid} component.
   * For example, this template shows row indices in the row headers:
   *
   * ```html
   * <wjGrid.FlexGrid itemsSource={this.state.data}>
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="RowHeader"
   *       template={ (context) => context.row.index + 1 } />
   * </wjGrid.FlexGrid>
   * ```
   *
   * Note that this template is applied to a row header cell, even if it is in a row that is
   * in edit mode. In order to provide an edit-mode version of a row header cell with alternate
   * content, define the <b>RowHeaderEdit</b> template.
   *
   * <b>RowHeaderEdit</b>
   *
   * Defines a template for a row header cell in edit mode. Must be a child of the
   * {@link wijmo.react.grid.FlexGrid} component. For example, this template shows dots in the header
   * of rows being edited:
   *
   * ```html
   * <wjGrid.FlexGrid itemsSource={this.state.data}>
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="RowHeaderEdit"
   *       template={ (context) => '...' } />
   * </wjGrid.FlexGrid>
   * ```
   *
   * Use the following <b>RowHeaderEdit</b> template to add the standard edit-mode indicator to cells where
   * the <b>RowHeader</b> template applies:
   *
   * ```html
   * <wjGrid.FlexGrid itemsSource={this.state.data}>
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="RowHeaderEdit"
   *       template={ (context) => '\u270e\ufe0e' } />
   * </wjGrid.FlexGrid>
   * ```
   *
   * <b>TopLeft</b>
   *
   * Defines a template for the top left cell. Must be a child of the {@link wijmo.react.grid.FlexGrid} component.
   * For example, this template shows a down/right glyph in the top-left cell of the grid:
   *
   * ```html
   * <wjGrid.FlexGrid itemsSource={this.state.data}>
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="TopLeft"
   *       template={ (context) => {
   *           return <span class="wj-glyph-down-right"></span>
   *       } }
   *   />
   * </wjGrid.FlexGrid>
   * ```
   *
   * <b>GroupHeader</b>
   *
   * Defines a template for a group header cell in a {@link GroupRow}. Must be a child of
   * the {@link wijmo.react.grid.FlexGridColumn} component.
   *
   * The <b>context.row</b> property contains an instance of the <b>GroupRow</b> class. If the grouping comes
   * from {@link CollectionView}, the <b>context.item</b> property references the {@link CollectionViewGroup} object.
   *
   * For example, this template uses a checkbox element as an expand/collapse toggle:
   *
   * ```html
   * <wjGrid.FlexGridColumn header="Country" binding="country">
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="GroupHeader"
   *       template={ (context) => {
   *          return <React.Fragment>
   *            <input type="checkbox"
   *                checked={context.row.isCollapsed}
   *                onChange={e =>
   *                    context.row.isCollapsed = e.target.checked as boolean
   *                } />
   *            {context.item.name} ({context.item.items.length} items)
   *          </React.Fragment>
   *          }
   *        }
   *   />
   * </wjGrid.FlexGridColumn>
   * ```
   *
   * <b>Group</b>
   *
   * Defines a template for a regular cell (not a group header) in a {@link GroupRow}. Must be a child of the
   * {@link wijmo.react.grid.FlexGridColumn} component. This cell type has an additional <b>context.value</b>
   * property. In cases where columns have the <b>aggregate</b> property specified, it contains the unformatted
   * aggregate value.
   *
   * For example, this template shows aggregate's value and kind for group row cells in the "Sales"
   * column:
   *
   * ```html
   * <wjGrid.FlexGridColumn header="Sales" binding="sales" aggregate="Avg">
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="Group"
   *       template={ (context) => {
   *          return <React.Fragment>
   *            Average: {wjcCore.Globalize.formatNumber(context.value, 'N0')}
   *          </React.Fragment>
   *          }
   *        }
   *   />
   * </wjGrid.FlexGridColumn>
   * ```
   *
   * <b>ColumnFooter</b>
   *
   * Defines a template for a regular cell in a <b>columnFooters</b> panel. Must be a child of the
   * {@link wijmo.react.grid.FlexGridColumn} component. This cell type provides an additional <b>context.value</b>
   * property available for binding that contains an aggregated cell value.
   *
   * For example, this template shows aggregate's value and kind for a footer cell in the "Sales"
   * column:
   *
   * ```html
   * <wjGrid.FlexGridColumn header="Sales" binding="sales" aggregate="Avg">
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="ColumnFooter"
   *       template={ (context) => {
   *          return <React.Fragment>
   *            Average: {wjcCore.Globalize.formatNumber(context.value, 'N0')}
   *          </React.Fragment>
   *          }
   *        }
   *   />
   * </wjGrid.FlexGridColumn>
   * ```
   *
   * <b>BottomLeft</b>
   *
   * Defines a template for the bottom left cells (at the intersection of the row header and column footer cells).
   * Must be a child of the {@link wijmo.react.grid.FlexGrid} component.
   * For example, this template shows a sigma glyph in the bottom-left cell of the grid:
   *
   * ```html
   * <wjGrid.FlexGrid itemsSource={this.state.data}>
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="BottomLeft"
   *       template={(context) => <span>&#931;</span>} />
   * </wjGrid.FlexGrid>
   * ```
   *
   * <b>NewCellTemplate</b>
   *
   * Defines a cell in a new row template. Must be a child of the {@link wijmo.react.grid.FlexGridColumn} component.
   * Note that the <b>context.item</b> property is undefined for this type of a cell.
   * For example, this cell template shows a placeholder in the Date column's cell in the "new row" item:
   *
   * ```html
   * <wjGrid.FlexGridColumn header="Date" binding="date">
   *   <wjGrid.FlexGridCellTemplate
   *       cellType="NewCellTemplate"
   *       template={ (context) => 'Enter a date here' } />
   * </wjGrid.FlexGridColumn>
   * ```
   */
    class FlexGridCellTemplate extends React.Component<any, any> {
        static readonly _CellRenderFuncProp: string;
        grid: wijmo.grid.FlexGrid;
        column: wijmo.grid.Column;
        ownerControl: wijmo.grid.FlexGrid | wijmo.grid.Column;
        cellType: CellTemplateType;
        readonly cellOverflow: string;
        readonly autoSizeRows: boolean;
        readonly forceFullEdit: boolean;
        readonly valuePaths: Object;
        readonly template: CellTemplateRender;
        componentDidMount(): void;
        componentWillUnmount(): void;
        componentDidUpdate(prevProps: any): void;
        render(): any;
        private _attachToControl;
        private _detachFromControl;
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.input.ListBox} control.
     */
    class ListBox extends ComponentBase {
        wjItemTemplate: ItemTemplateRender;
        constructor(props: any);
        componentDidMount(): any;
    }
    /**
     * React component that encapsulates the {@link wijmo.input.MultiSelectListBox} control.
     */
    class MultiSelectListBox extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.ComboBox} control.
     */
    class ComboBox extends ComponentBase {
        wjItemTemplate: ItemTemplateRender;
        constructor(props: any);
        componentDidMount(): any;
    }
    /**
     * React component that encapsulates the {@link wijmo.input.AutoComplete} control.
     */
    class AutoComplete extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.Calendar} control.
     */
    class Calendar extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.ColorPicker} control.
     */
    class ColorPicker extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.InputMask} control.
     */
    class InputMask extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.InputColor} control.
     */
    class InputColor extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.MultiSelect} control.
     */
    class MultiSelect extends ComponentBase {
        wjItemTemplate: ItemTemplateRender;
        constructor(props: any);
        componentDidMount(): any;
    }
    /**
     * React component that encapsulates the {@link wijmo.input.MultiAutoComplete} control.
     */
    class MultiAutoComplete extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.InputNumber} control.
     */
    class InputNumber extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.InputDate} control.
     */
    class InputDate extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.InputTime} control.
     */
    class InputTime extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.InputDateTime} control.
     */
    class InputDateTime extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.input.Menu} control.
     */
    class Menu extends ComponentBase {
        wjItemTemplate: ItemTemplateRender;
        private _definedHeader;
        private _value;
        private _contextMenuData;
        readonly contextMenuProp: string;
        constructor(props: any);
        value: any;
        componentDidMount(): any;
        componentDidUpdate(prevProps: any): void;
        componentWillUnmount(): void;
        protected _createControl(): any;
        private _updateHeader;
        private _fmtItem;
        private _contextMenuGetElementsIfChanged;
        private _contextMenuGetElements;
        private _contextMenuBindListeners;
        private _contextMenuUnbindListeners;
    }
    /**
     * React component that represents an item in a {@link wijmo.react.input.Menu}.
     */
    class MenuItem extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        contentRoot: HTMLElement;
        value: any;
        cmd: any;
        cmdParam: any;
        constructor(props: any);
        protected _createControl(): any;
        _renderImpl(): any;
        added(toItem: HTMLElement): void;
    }
    /**
     * React component that represents an item separator in a {@link wijmo.react.input.Menu}.
     */
    class MenuSeparator extends ComponentBase {
        _parentProp: string;
        _siblingId: string;
        contentRoot: HTMLElement;
        constructor(props: any);
        protected _createControl(): any;
        _renderImpl(): any;
        added(toItem: HTMLElement): void;
    }
    /**
    * TBD
    */
    interface ItemTemplateContext {
        control: wijmo.Control;
        item: any;
        itemIndex: number;
    }
    /**
     * TBD
     */
    type ItemTemplateRender = (context: ItemTemplateContext) => any;
    /**
     * React component that encapsulates the {@link wijmo.input.Popup} control.
     */
    class Popup extends ComponentBase {
        constructor(props: any);
        _renderImpl(): any;
    }
    /**
     * React component that encapsulates the {@link wijmo.input.CollectionViewNavigator} control.
     */
    class CollectionViewNavigator extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.olap.PivotGrid} control.
     */
    class PivotGrid extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.olap.PivotChart} control.
     */
    class PivotChart extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.olap.PivotPanel} control.
     */
    class PivotPanel extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.olap.Slicer} control.
     */
    class Slicer extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.viewer.ReportViewer} control.
     */
    class ReportViewer extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.viewer.PdfViewer} control.
     */
    class PdfViewer extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.nav.TreeView} control.
     */
    class TreeView extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.nav.TabPanel} control.
     */
    class TabPanel extends ComponentBase {
        constructor(props: any);
        protected _createControl(): any;
        componentDidMount(): void;
    }
    /**
     * React component that represents a {@link wijmo.nav.Tab} in a {@link wijmo.react.nav.TabPanel}.
     */
    class Tab extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
        protected _createControl(): any;
        protected _renderImpl(): any;
    }
    /**
     * React component that encapsulates the {@link wijmo.nav.Accordion} control.
     */
    class Accordion extends ComponentBase {
        constructor(props: any);
        protected _createControl(): any;
        componentDidMount(): void;
    }
    /**
     * React component that represents a {@link wijmo.nav.AccordionPane} in a {@link wijmo.react.nav.Accordion}.
     */
    class AccordionPane extends ComponentBase {
        _parentProp: string;
        constructor(props: any);
        protected _createControl(): any;
        protected _renderImpl(): any;
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.Codabar} control.
     */
    class BarcodeCodabar extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.Ean8} control.
     */
    class BarcodeEan8 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.Ean13} control.
     */
    class BarcodeEan13 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.Code39} control.
     */
    class BarcodeCode39 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.Code128} control.
     */
    class BarcodeCode128 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.Gs1_128} control.
     */
    class BarcodeGs1_128 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.UpcA} control.
     */
    class BarcodeUpcA extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.UpcE0} control.
     */
    class BarcodeUpcE0 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.UpcE1} control.
     */
    class BarcodeUpcE1 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.common.QrCode} control.
     */
    class BarcodeQrCode extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarOmnidirectional} control.
     */
    class BarcodeGs1DataBarOmnidirectional extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarTruncated} control.
     */
    class BarcodeGs1DataBarTruncated extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarStacked} control.
     */
    class BarcodeGs1DataBarStacked extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarStackedOmnidirectional} control.
     */
    class BarcodeGs1DataBarStackedOmnidirectional extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarLimited} control.
     */
    class BarcodeGs1DataBarLimited extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarExpanded} control.
     */
    class BarcodeGs1DataBarExpanded extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Gs1DataBarExpandedStacked} control.
     */
    class BarcodeGs1DataBarExpandedStacked extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.Pdf417} control.
     */
    class BarcodePdf417 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.composite.MicroPdf417} control.
     */
    class BarcodeMicroPdf417 extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare module wijmo.react {
    /**
     * React component that encapsulates the {@link wijmo.barcode.specialized.DataMatrixEcc000} control.
     */
    class BarcodeDataMatrixEcc000 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.specialized.DataMatrixEcc200} control.
     */
    class BarcodeDataMatrixEcc200 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.specialized.Code49} control.
     */
    class BarcodeCode49 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.specialized.Code93} control.
     */
    class BarcodeCode93 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.specialized.Itf14} control.
     */
    class BarcodeItf14 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.specialized.Interleaved2of5} control.
     */
    class BarcodeInterleaved2of5 extends ComponentBase {
        constructor(props: any);
    }
    /**
     * React component that encapsulates the {@link wijmo.barcode.specialized.JapanesePostal} control.
     */
    class BarcodeJapanesePostal extends ComponentBase {
        constructor(props: any);
    }
}
declare module wijmo.react {
}
declare var Wj: typeof wijmo.react;
