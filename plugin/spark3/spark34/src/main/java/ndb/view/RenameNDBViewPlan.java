/*
 *  Copyright (C) Vast Data Ltd.
 */

package ndb.view;

import org.apache.spark.sql.catalyst.expressions.Attribute;
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan;
import org.apache.spark.sql.catalyst.plans.logical.RenameTable;
import scala.collection.immutable.IndexedSeq;
import scala.collection.immutable.Seq;

import static ndb.NDBParser.EMPTY_LOGICAL_PLAN_SEQ;

public class RenameNDBViewPlan
        extends LogicalPlan
{
    private Seq<LogicalPlan> children;
    final RenameTable original;

    private RenameNDBViewPlan(final RenameTable original) {
        super();
        this.original = original;
        this.children = (scala.collection.immutable.Seq<LogicalPlan>) original.children();
    }

    @Override
    public Seq<Attribute> output()
    {
        return (Seq<Attribute>) scala.collection.immutable.Seq$.MODULE$.<Attribute>empty();
    }

    @Override
    public Seq<LogicalPlan> children()
    {
        if (this.children == null) {
            return EMPTY_LOGICAL_PLAN_SEQ;
        }
        else {
            return (Seq<LogicalPlan>) children;
        }
    }

    @Override
    @Override
    public LogicalPlan withNewChildrenInternal(scala.collection.IndexedSeq<LogicalPlan> newChildren) {
        {
            this.children = newChildren;
            return this;
        }
    }

    @Override
    public boolean canEqual(Object that)
    {
        return that instanceof RenameNDBViewPlan;
    }

    @Override
    public Object productElement(int n)
    {
        return this;
    }

    @Override
    public int productArity()
    {
        return 0;
    }

    public static RenameNDBViewPlan instance(final RenameTable plan)
    {
        return new RenameNDBViewPlan(plan);
    }

    @Override
    public boolean resolved()
    {
        return childrenResolved();
    }
}
