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
declare module wijmo.grid.transposed {
    /**
     * Extends the {@link FlexGrid} control to display data using a transposed
     * layout, where columns represent data items and rows represent item
     * properties.
     *
     * Features based on regular (non-transposed) data sources only apply to the
     * original data source, so you can sort, filter, group, or paginate items before
     * assigning them to the {@link TransposedGrid}, but if you later change those
     * parameters, the grid will not be automatically updated.
     *
     * Also, some regular {@link FlexGrid} features are not available in the
     * {@link TransposedGrid} because they don't make sense with transposed data
     * sources.
     *
     * For example, adding or removing rows in a transposed grid would mean adding
     * or removing properties to the data items. For this reason, the {@link allowAddNew}
     * and {@link allowDelete} properties are disabled.
     *
     * Also, the {@link autoGenerateColumns} property has no effect on the
     * {@link TransposedGrid}, which has an {@link autoGenerateRows} property instead.
     */
    class TransposedGrid extends wijmo.grid.FlexGrid {
        protected _view: wijmo.collections.ICollectionView;
        protected _keyPrefix: string;
        protected _autoGenRows: boolean;
        protected _toRowInfo: any;
        _rowInfo: wijmo.grid.ColumnCollection;
        /**
         * Initializes a new instance of the {@link TransposedGrid} class.
         *
         * @param element The DOM element that hosts the control, or a CSS selector for the host element (e.g. '#theCtrl').
         * @param options JavaScript object containing initialization data for the control.
         */
        constructor(element: any, options?: any);
        /**
         * Gets or sets a value that determines whether the grid should generate
         * rows automatically based on the {@link itemsSource}.
         *
         * The default value for this property is <b>true</b>.
         */
        autoGenerateRows: boolean;
        refresh(fullUpdate?: boolean): void;
        allowAddNew: boolean;
        allowDelete: boolean;
        onRowEditEnded(e: wijmo.grid.CellRangeEventArgs): void;
        protected _getCollectionView(value: any): wijmo.collections.ICollectionView;
        _getColumnTypes(arr: any[]): wijmo.IBindingInfo[];
        _copy(key: string, value: any): boolean;
        onLoadedRows(e?: wijmo.EventArgs): void;
        _getBindingColumn(p: wijmo.grid.GridPanel, r: number, c: wijmo.grid.Column): wijmo.grid.Column;
        private _copyProps;
        _rowInfoChanged(): void;
        _sourceViewChanged(sender: wijmo.collections.ICollectionView, e: wijmo.collections.NotifyCollectionChangedEventArgs): void;
        _transposeItemsSource(arr: any[]): wijmo.collections.ObservableArray;
        _supportsProxies(): boolean;
        _createProxy(arr: any[], rowInfo: any, proxyKeys: string[]): any;
        _createTransposedObject(arr: any[], rowInfo: any, keyPrefix: string): {
            _arr: any[];
            _rowInfo: any;
        };
        _getRowInfo(arr: any[]): any[];
    }
    /**
     * This class is for internal use only.
     */
    class TransposedGridRow extends wijmo.grid.Column {
    }
}
declare module wijmo.grid.transposed {
}
