import { useState } from "react";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

export default function LoginError({open, setOpen}) {
  const navigate = useNavigate();

  const handleClose = () => {
    setOpen(false)
    navigate("/register", { state: { opened: open}})
  }

  return (
    <>
        <Dialog open={open} onClose={handleClose}>
          <DialogTitle>{"Não autorizado!"}</DialogTitle>
          <DialogContent>
            <DialogContentText>
              As senhas precisam ser iguais!
            </DialogContentText>
            <DialogActions>
              <Button onClick={handleClose} autoFocus>
                Fechar
              </Button>
            </DialogActions>
          </DialogContent>
        </Dialog>
    </>
  );
}
