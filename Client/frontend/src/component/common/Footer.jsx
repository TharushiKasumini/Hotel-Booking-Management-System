const FooterComponent = () => {
  return (
    <footer>
      <span className="my-footer">
        Hotel Golden Horizon | All Right Reserved &copy;{" "}
        {new Date().getFullYear()}
      </span>
    </footer>
  );
};

export default FooterComponent;
