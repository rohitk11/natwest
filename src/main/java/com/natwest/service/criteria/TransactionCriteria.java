package com.natwest.service.criteria;

import com.natwest.domain.enumeration.TransactionTypeEnum;
import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BigDecimalFilter;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.natwest.domain.Transaction} entity. This class is used
 * in {@link com.natwest.web.rest.TransactionResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /transactions?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
public class TransactionCriteria implements Serializable, Criteria {

    /**
     * Class for filtering TransactionTypeEnum
     */
    public static class TransactionTypeEnumFilter extends Filter<TransactionTypeEnum> {

        public TransactionTypeEnumFilter() {}

        public TransactionTypeEnumFilter(TransactionTypeEnumFilter filter) {
            super(filter);
        }

        @Override
        public TransactionTypeEnumFilter copy() {
            return new TransactionTypeEnumFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private TransactionTypeEnumFilter type;

    private BigDecimalFilter amount;

    private StringFilter currency;

    private LongFilter accountFrom;

    private LongFilter accountNumber;

    private Boolean distinct;

    public TransactionCriteria() {}

    public TransactionCriteria(TransactionCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.type = other.type == null ? null : other.type.copy();
        this.amount = other.amount == null ? null : other.amount.copy();
        this.currency = other.currency == null ? null : other.currency.copy();
        this.accountFrom = other.accountFrom == null ? null : other.accountFrom.copy();
        this.accountNumber = other.accountNumber == null ? null : other.accountNumber.copy();
        this.distinct = other.distinct;
    }

    @Override
    public TransactionCriteria copy() {
        return new TransactionCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public TransactionTypeEnumFilter getType() {
        return type;
    }

    public TransactionTypeEnumFilter type() {
        if (type == null) {
            type = new TransactionTypeEnumFilter();
        }
        return type;
    }

    public void setType(TransactionTypeEnumFilter type) {
        this.type = type;
    }

    public BigDecimalFilter getAmount() {
        return amount;
    }

    public BigDecimalFilter amount() {
        if (amount == null) {
            amount = new BigDecimalFilter();
        }
        return amount;
    }

    public void setAmount(BigDecimalFilter amount) {
        this.amount = amount;
    }

    public StringFilter getCurrency() {
        return currency;
    }

    public StringFilter currency() {
        if (currency == null) {
            currency = new StringFilter();
        }
        return currency;
    }

    public void setCurrency(StringFilter currency) {
        this.currency = currency;
    }

    public LongFilter getAccountFrom() {
        return accountFrom;
    }

    public LongFilter accountFrom() {
        if (accountFrom == null) {
            accountFrom = new LongFilter();
        }
        return accountFrom;
    }

    public void setAccountFrom(LongFilter accountFrom) {
        this.accountFrom = accountFrom;
    }

    public LongFilter getAccountNumber() {
        return accountNumber;
    }

    public LongFilter accountNumber() {
        if (accountNumber == null) {
            accountNumber = new LongFilter();
        }
        return accountNumber;
    }

    public void setAccountNumber(LongFilter accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TransactionCriteria that = (TransactionCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(type, that.type) &&
            Objects.equals(amount, that.amount) &&
            Objects.equals(currency, that.currency) &&
            Objects.equals(accountFrom, that.accountFrom) &&
            Objects.equals(accountNumber, that.accountNumber) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, currency, accountFrom, accountNumber, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (type != null ? "type=" + type + ", " : "") +
            (amount != null ? "amount=" + amount + ", " : "") +
            (currency != null ? "currency=" + currency + ", " : "") +
            (accountFrom != null ? "accountFrom=" + accountFrom + ", " : "") +
            (accountNumber != null ? "accountNumber=" + accountNumber + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
