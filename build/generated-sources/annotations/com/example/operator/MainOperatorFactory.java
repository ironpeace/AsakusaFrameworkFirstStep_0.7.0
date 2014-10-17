package com.example.operator;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.operator.KeyInfo;
import com.asakusafw.vocabulary.operator.MasterJoin;
import com.asakusafw.vocabulary.operator.OperatorFactory;
import com.asakusafw.vocabulary.operator.OperatorInfo;
import com.asakusafw.vocabulary.operator.Update;
import com.example.modelgen.dmdl.model.ItemMaster;
import com.example.modelgen.dmdl.model.OutputSales;
import com.example.modelgen.dmdl.model.SalesDetail;
import java.util.Arrays;
import javax.annotation.Generated;
/**
 * {@link MainOperator}に関する演算子ファクトリークラス。
 * @see MainOperator
 */
@Generated("OperatorFactoryClassGenerator:0.1.0")@OperatorFactory(MainOperator.class) public class MainOperatorFactory {
    /**
     * マスター結合演算子
     */
    public static final class JoinedSales implements Operator {
        private final FlowElementResolver $;
        /**
         *   結合済
         */
        public final Source<com.example.modelgen.dmdl.model.JoinedSales> joined;
        /**
         * 結合に失敗したデータ
         */
        public final Source<SalesDetail> missed;
        JoinedSales(Source<ItemMaster> master, Source<SalesDetail> tx) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(MasterJoin.class);
            builder.declare(MainOperator.class, MainOperatorImpl.class, "joinedSales");
            builder.declareParameter(ItemMaster.class);
            builder.declareParameter(SalesDetail.class);
            builder.addInput("master", master, new ShuffleKey(Arrays.asList(new String[]{"itemId"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addInput("tx", tx, new ShuffleKey(Arrays.asList(new String[]{"itemId"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addOutput("joined", com.example.modelgen.dmdl.model.JoinedSales.class);
            builder.addOutput("missed", tx);
            builder.addAttribute(FlowBoundary.SHUFFLE);
            builder.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder.toResolver();
            this.$.resolveInput("master", master);
            this.$.resolveInput("tx", tx);
            this.joined = this.$.resolveOutput("joined");
            this.missed = this.$.resolveOutput("missed");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MainOperatorFactory.JoinedSales as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * マスター結合演算子
     * @param master   マスター
     * @param tx   トランザクション
     * @return 生成した演算子オブジェクト
     * @see MainOperator#joinedSales(ItemMaster, SalesDetail)
     */
    @OperatorInfo(kind = MasterJoin.class, input = {@OperatorInfo.Input(name = "master", type = ItemMaster.class, 
                position = 0),@OperatorInfo.Input(name = "tx", type = SalesDetail.class, position = 1)}, output = {@
                OperatorInfo.Output(name = "joined", type = com.example.modelgen.dmdl.model.JoinedSales.class),@
                OperatorInfo.Output(name = "missed", type = SalesDetail.class)}, parameter = {}) public 
            MainOperatorFactory.JoinedSales joinedSales(@KeyInfo(group = {@KeyInfo.Group(expression = "itemId")}, order 
            = {}) Source<ItemMaster> master,@KeyInfo(group = {@KeyInfo.Group(expression = "itemId")}, order = {}) Source
            <SalesDetail> tx) {
        return new MainOperatorFactory.JoinedSales(master, tx);
    }
    /**
     * 更新演算子
     */
    public static final class Updated implements Operator {
        private final FlowElementResolver $;
        /**
         * 結果
         */
        public final Source<OutputSales> out;
        Updated(Source<OutputSales> in) {
            OperatorDescription.Builder builder0 = new OperatorDescription.Builder(Update.class);
            builder0.declare(MainOperator.class, MainOperatorImpl.class, "updated");
            builder0.declareParameter(OutputSales.class);
            builder0.addInput("in", in);
            builder0.addOutput("out", in);
            builder0.addAttribute(ObservationCount.DONT_CARE);
            this.$ = builder0.toResolver();
            this.$.resolveInput("in", in);
            this.out = this.$.resolveOutput("out");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName0 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MainOperatorFactory.Updated as(String newName0) {
            this.$.setName(newName0);
            return this;
        }
    }
    /**
     * 更新演算子
     * @param in   入力
     * @return 生成した演算子オブジェクト
     * @see MainOperator#updated(OutputSales)
     */
    @OperatorInfo(kind = Update.class, input = {@OperatorInfo.Input(name = "in", type = OutputSales.class, position = 0)
            }, output = {@OperatorInfo.Output(name = "out", type = OutputSales.class)}, parameter = {}) public 
            MainOperatorFactory.Updated updated(Source<OutputSales> in) {
        return new MainOperatorFactory.Updated(in);
    }
}