import React, { useEffect, useState } from "react";
import { Space, Table, Tag } from "antd";
import type { TableProps } from "antd";
import { useQuery } from "@tanstack/react-query";
import { Link } from "react-router";
import { UserApi, type BasicUser } from "../core/openapi";


const columns: TableProps<BasicUser>["columns"] = [
  {
    title: "Name",
    dataIndex: "username",
    key: "username",
    render: text => <a>{text}</a>,
  },
  {
    title: "Nick",
    dataIndex: "nickname",
    key: "nickname",
  },
  {
    title: "createdAt",
    dataIndex: "createdAt",
    key: "createdAt",
  },
  // {
  //   title: "Roles",
  //   key: "roles",
  //   dataIndex: "roles",
  //   render: (_, { roles }) => (
  //     <>
  //       {roles.map(tag => {
  //         let color = tag.length > 5 ? "geekblue" : "green";
  //         if (tag === "loser") {
  //           color = "volcano";
  //         }
  //         return (
  //           <Tag color={color} key={tag}>
  //             {tag.toUpperCase()}
  //           </Tag>
  //         );
  //       })}
  //     </>
  //   ),
  // },
  {
    title: "Action",
    key: "action",
    render: (_, record) => (
      <Space size="middle">
        <Link to={`/user/${record.id}`}>Edit</Link>
        <a>Delete</a>
      </Space>
    ),
  },
];

const User: React.FC = () => {
  // const [posts, setPosts] = useState([]);
  // const [loading, setLoading] = useState(true);

  const userapi = new UserApi()
  const { isPending, error, data } = useQuery({
    queryKey: ["repoData"],
    queryFn: () => userapi.listUsers().then(res => res),
  });

  if (isPending) {
    return <div>Loading...</div>;
  }

  return <Table<BasicUser> columns={columns} dataSource={data} />;

  // return (
  //   <div>
  //     {data.map((user, index) => (
  //       <div>{user.nickname}</div>
  //     ))}
  //   </div>
  // );
};

export default User;
