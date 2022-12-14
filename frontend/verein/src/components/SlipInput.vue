<template>
  <div v-if="store.contents" class="q-pa-md" style="max-width: 400px">

    <q-form
      @submit="onSubmit"
      @reset="onReset"
      class="q-gutter-md"
    >
      <q-input
        filled
        v-model="store.contents.invoiceNumber"
        label="Invoice Number"
        hint="Number of the invoice"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="store.contents.date"
        label="date"
        hint="Date"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="store.contents.biller"
        label="Biller"
        hint="Biller"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="store.contents.customerId"
        label="Customer ID"
        hint="Customer ID"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="store.contents.totalBruttoAmount"
        label="Total Brutto Amount"
        hint="Total Brutto Amount"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="store.contents.totalNettoAmount"
        label="Total Netto Amount"
        hint="Total Netto Amount"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-input
        filled
        v-model="store.contents.description"
        label="Description"
        hint="Description"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type something']"
      />

      <q-list>
        <template :key="store.contents.invoiceNumber + pos.position" v-for="pos in store.contents.invoiceItems">
          <q-input
            filled
            v-model="pos.position"
            label="Position"
            hint="Position"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            filled
            v-model="pos.description"
            label="Description"
            hint="Description"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            filled
            v-model="pos.count"
            label="Count"
            hint="Count"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            filled
            v-model="pos.nettoPrice"
            label="Netto Price"
            hint="Netto Price"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            filled
            v-model="pos.bruttoPrice"
            label="Brutto Price"
            hint="Brutto Price"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />

          <q-input
            filled
            v-model="pos.tax"
            label="Tax"
            hint="Tax"
            lazy-rules
            :rules="[ val => val && val.length > 0 || 'Please type something']"
          />
        </template>
      </q-list>

      <div>
        <q-btn label="Submit" type="submit" color="primary"/>
        <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
      </div>
    </q-form>

  </div>
</template>

<script lang="ts">
import { useInvoiceStore } from 'stores/invoice-store';

export default {
  name: 'store.contentsInput',

  setup() {
    const store = useInvoiceStore();

    return { store }
  }
}
</script>

<style scoped>

</style>
