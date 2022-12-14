<template>
  <div>
    <q-table title="Open Invoices" :rows="rows" :columns="columns" row-key="name">
      <template v-slot:header="props">
        <q-tr :props="props">
          <q-th auto-width />
          <q-th v-for="col in props.cols" :key="col.name" :props="props">
            {{ col.label }}
          </q-th>
          <q-th auto-width />
        </q-tr>
      </template>
      <template v-slot:body="props">
        <q-tr :props="props">
          <q-td auto-width>
            <q-btn size="sm" color="accent" round dense @click="props.row.expand = !props.row.expand"
              :icon="props.row.expand ? 'remove' : 'add'" />
          </q-td>
          <q-td v-for="col in props.cols" :key="col.name" :props="props">
            {{ col.value }}
          </q-td>
          <q-td>
            <q-btn size="sm" color="primary" round icon="check" />
          </q-td>
        </q-tr>
        <q-tr v-show="props.row.expand" :props="props">
          <q-td colspan="100%">
            <div class="text-left">Description: "{{ props.row.description }}"</div>
            <ul>
              <li v-for="item in props.row.invoiceItems" :key="item.position">
                {{ item.count }}x {{ item.description }} - {{ item.nettoPrice }} €
              </li>
            </ul>
          </q-td>
        </q-tr>
      </template>
    </q-table>
  </div>
</template>

<script lang="ts">
import { InvoiceContents } from 'src/stores/invoice-store';
import {
  defineComponent,
  PropType,
  toRef,
} from 'vue';

export default defineComponent({
  name: 'TableComponent',
  props: {
    invoices: {
      type: Array as PropType<InvoiceContents[]>,
      required: true
    },
  },
  setup(props) {
    let columns = [
      { name: 'invoiceNumber', label: 'Invoice Number', field: 'invoiceNumber', sortable: true },
      {
        name: 'totalAmount', label: 'Total Amount', field: 'totalBruttoAmount',
        sortable: true, format: (val: number) => `${val} €`,
      },
      { name: 'date', label: 'Date', field: 'date', sortable: true },
    ]
    let rows = toRef(props, 'invoices');
    return { rows, columns };
  },
});
</script>
