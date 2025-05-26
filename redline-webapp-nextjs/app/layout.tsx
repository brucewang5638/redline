"use client";

import React from "react";
import { RotateLeftOutlined, UserOutlined } from "@ant-design/icons";
import type { MenuProps } from "antd";
import { Layout, Menu, theme } from "antd";
import { useRouter } from "next/navigation";

const { Header, Content, Footer, Sider } = Layout;

const siderStyle: React.CSSProperties = {
  overflow: "auto",
  height: "100vh",
  position: "sticky",
  insetInlineStart: 0,
  top: 0,
  bottom: 0,
  scrollbarWidth: "thin",
  scrollbarGutter: "stable"
};

const menuItems = [
  {
    icon: UserOutlined,
    label: "user",
    path: "/user"
  },
  {
    icon: RotateLeftOutlined,
    label: "role",
    path: "/role"
  }
];

const App: React.FC = ({ children }: React.PropsWithChildren) => {
  const {
    token: { colorBgContainer, borderRadiusLG }
  } = theme.useToken();

  const router = useRouter();

  const items: MenuProps["items"] = menuItems.map((obj, index) => ({
    key: String(index + 1),
    icon: React.createElement(obj.icon),
    label: obj.label,
    onClick: () => {
      router.push(obj.path);
    }
  }));

  return (
    <html>
      <body>
        <Layout hasSider>
          <Sider style={siderStyle}>
            <div className="demo-logo-vertical" />
            <Menu theme="dark" mode="inline" defaultSelectedKeys={["1"]} items={items} />
          </Sider>
          <Layout>
            <Header style={{ padding: 0, background: colorBgContainer }} />
            <Content style={{ margin: "24px 16px 0", overflow: "initial" }}>
              <div
                style={{
                  padding: 24,
                  textAlign: "center",
                  background: colorBgContainer,
                  borderRadius: borderRadiusLG
                }}
              >
                {children}
              </div>
            </Content>
            <Footer style={{ textAlign: "center" }}>Ant Design ©{new Date().getFullYear()} Created by Ant UED</Footer>
          </Layout>
        </Layout>
      </body>
    </html>
  );
};

export default App;
