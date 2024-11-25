import { useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

export default function Unauthorized() {
  const [open, setClose] = useState();
  const navigate = useNavigate();

  const handleClose = () => {
    setClose(true);
  };

  return (
    <>
        <Dialog open={open} onClick={handleClose}>
          <DialogTitle>{"Não autorizado!"}</DialogTitle>
          <DialogContent>
            <DialogContentText>
              Infelizmente não encontramos o seu usuário. Deseja criar uma
              conta?
            </DialogContentText>
            <DialogActions>
              <Button onClick={handleClose} autoFocus>
                Fechar
              </Button>
              <Button onClick={navigate("/register")}>Nova Conta</Button>
            </DialogActions>
          </DialogContent>
        </Dialog>
    </>
  );
}
