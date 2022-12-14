<template>
  <div>
    <q-table title="Open Invoices" :rows="rows" :columns="columns" row-key="name">
      <template v-slot:body="props">
        <q-tr :props="props">
          <q-td key="id" :props="props">
            {{ props.row.id }}
          </q-td>
          <q-td key="totalAmount" :props="props">
            {{ props.row.totalAmount }}
          </q-td>
          <q-td key="currency" :props="props">
            {{ props.row.currency }}
          </q-td>
          <q-td key="image" :props="props">
            {{ props.row.image }}
          </q-td>
          <q-td key="created" :props="props">
            {{ props.row.created }}
          </q-td>
          <q-td key="done" :props="props">
            <q-btn color="primary" icon-right="check" label="Done" />
          </q-td>
        </q-tr>
      </template>
    </q-table>
  </div>
</template>

<script lang="ts">
import {
  defineComponent,
  PropType,
  toRef,
} from 'vue';
import { Invoice } from './models';

export default defineComponent({
  name: 'TableComponent',
  props: {
    invoices: {
      type: Array as PropType<Invoice[]>,
      required: true
    },
  },
  setup(props) {
    let columns = [
      { name: 'id', label: 'ID', field: 'id', sortable: true },
      { name: 'totalAmount', label: 'Total Amount', field: 'totalAmount', sortable: true },
      { name: 'currency', label: 'Currency', field: 'currency', sortable: true },
      { name: 'image', label: 'Image', field: 'image', sortable: true },
      { name: 'created', label: 'Created At', field: 'created', sortable: true },
      { name: 'done', label: 'Done?', },
    ]
    let rows = toRef(props, 'invoices');
    return { rows, columns };
  },
});
</script>
