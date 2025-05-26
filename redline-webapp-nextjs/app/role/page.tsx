"use client";

import React from "react";
import { Space, Table } from "antd";
import type { TableProps } from "antd";

interface DataType {
  key: string;
  name: string;
}

const columns: TableProps<DataType>["columns"] = [
  {
    title: "Name",
    dataIndex: "name",
    key: "name",
    render: text => <a>{text}</a>
  },
  {
    title: "Action",
    key: "action",
    render: (_, record) => (
      <Space size="middle">
        <a>Detail</a>
        <a>Delete</a>
      </Space>
    )
  }
];

const data: DataType[] = [
  {
    key: "1",
    name: "Nice"
  },
  {
    key: "2",
    name: "Developer"
  },
  {
    key: "3",
    name: "Coll"
  },
  {
    key: "4",
    name: "Loser"
  },
  {
    key: "5",
    name: "Teacher"
  }
];

const App: React.FC = () => <Table<DataType> columns={columns} dataSource={data} />;

export default App;
