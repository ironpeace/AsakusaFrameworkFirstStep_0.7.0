package com.example.operator;
import com.example.modelgen.dmdl.model.ItemMaster;
import com.example.modelgen.dmdl.model.JoinedSales;
import com.example.modelgen.dmdl.model.SalesDetail;
import javax.annotation.Generated;
/**
 * {@link MainOperator}に関する演算子実装クラス。
 */
@Generated("OperatorImplementationClassGenerator:0.1.0") public class MainOperatorImpl extends MainOperator {
    /**
     * インスタンスを生成する。
     */
    public MainOperatorImpl() {
        return;
    }
    @Override public JoinedSales joinedSales(ItemMaster master, SalesDetail tx) {
        throw new UnsupportedOperationException("マスタ結合演算子は組み込みの方法で処理されます");
    }
}