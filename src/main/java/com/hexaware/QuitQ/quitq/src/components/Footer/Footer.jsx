import React from "react";
import { FacebookOutlined, LinkedinOutlined, TwitterOutlined } from "@ant-design/icons";
import { Col, Row, Typography } from "antd";

import "./Footer.css"; // Import your CSS file for styling if needed

const Footer = () => {
    return (
        <div className="footer-wrapper">
            <Row>
                <Col span={12}>
                    <Typography.Title level={3} className="footer-heading">Buy Everything</Typography.Title>
                    <Typography.Text className="contact-info">(066) 696-66-23</Typography.Text>
                    <Typography.Text className="contact-info">
                        From 08:00 to 20:00 without breaks and weekends
                    </Typography.Text>
                </Col>
                <Col span={12}>
                    <div className="footer-social">
                        <Typography.Title level={3} className="footer-heading">Social Networks</Typography.Title>
                        <div className="social-icons">
                            <a href="https://www.linkedin.com/in/merikbest/" target="_blank" rel="noopener noreferrer">
                                <LinkedinOutlined className="social-icon" />
                            </a>
                            <a href="#" target="_blank" rel="noopener noreferrer">
                                <FacebookOutlined className="social-icon" />
                            </a>
                            <a href="#" target="_blank" rel="noopener noreferrer">
                                <TwitterOutlined className="social-icon" />
                            </a>
                        </div>
                    </div>
                </Col>
            </Row>
            <Row className="footer-copyright">
                <Typography.Text className="copyright-text">© 2024 Buy Everything. All Rights Reserved.</Typography.Text>
            </Row>
        </div>
    );
};

export default Footer;
